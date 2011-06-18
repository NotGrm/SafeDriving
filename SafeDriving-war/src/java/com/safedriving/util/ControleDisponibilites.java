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
    static DisponibilityServiceLocal srv;

    public static Disponibility getDisponibility(Personnel pers, Date date, int duree) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, duree);

        Date dateDebut = cal.getTime();

        cal.add(Calendar.HOUR, duree);

        Date dateFin = cal.getTime();

        System.out.println(dateDebut);
        System.out.println(dateFin);

        return srv.getForUserAtDate(pers, dateDebut, dateFin);
    }
    
    public static void manageDisponibility(Disponibility dispo, Date date, int duree) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, duree);

        Date dateDebut = cal.getTime();

        cal.add(Calendar.HOUR, duree);

        Date dateFin = cal.getTime();
    }
}
