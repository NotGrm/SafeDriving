/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.util;

import com.safedriving.model.Disponibility;
import com.safedriving.model.Personnel;
import com.safedriving.services.DisponibilityServiceLocal;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author Grm
 */
public class ControleDisponibilites {

    @EJB
    DisponibilityServiceLocal srv;

    public Disponibility getDisponibility(Personnel pers, Date date, int duree) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, duree);

        Date dateDebut = cal.getTime();

        cal.add(Calendar.HOUR, duree);

        Date dateFin = cal.getTime();

        System.out.println(dateDebut);
        System.out.println(dateFin);

        System.out.println("coucou");
        return srv.getForUserAtDate(pers, dateDebut, dateFin);
    }

    public void manageDisponibility(Disponibility dispo, Date date, int duree) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, duree);

        Date dateDebut = cal.getTime();

        cal.add(Calendar.HOUR, duree);

        Date dateFin = cal.getTime();

        if (dispo.getDateDebut().equals(dateDebut)) {
            if (dispo.getDateFin().equals(dateFin)) {
                srv.remove(dispo);
            } else {
                dispo.setDateDebut(dateFin);
                srv.refresh(dispo);
            }
        } else {
            if (dispo.getDateFin().equals(dateFin)) {
                dispo.setDateFin(dateDebut);
                srv.refresh(dispo);
            } else {
                Disponibility newDispo = new Disponibility();
                newDispo.setFormateur(dispo.getFormateur());
                newDispo.setDateDebut(dateFin);
                newDispo.setDateFin(dispo.getDateFin());
                srv.add(newDispo);
                
                dispo.setDateFin(dateDebut);
                srv.refresh(dispo);
                
            }
        }
    }
}
