/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Disponibility;
import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.model.Pratique;
import com.safedriving.model.SessionFormation;
import com.safedriving.model.Theorique;
import com.safedriving.model.TypeSessionPratique;
import com.safedriving.model.Vehicule;
import com.safedriving.services.DisponibilityServiceLocal;
import com.safedriving.services.LieuServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.PratiqueServiceLocal;
import com.safedriving.services.TheoriqueServiceLocal;
import com.safedriving.services.TypeSessionPratiqueServiceLocal;
import com.safedriving.services.VehiculeServiceLocal;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Grm
 */
public class AddSessionServlet extends HttpServlet {

    @EJB
    PratiqueServiceLocal pratiqueSrv;
    @EJB
    TheoriqueServiceLocal theoriqueSrv;
    @EJB
    PersonnelServiceLocal personnelSrv;
    @EJB
    LieuServiceLocal lieuSrv;
    @EJB
    VehiculeServiceLocal vehiculeSrv;
    @EJB
    TypeSessionPratiqueServiceLocal typeSrv;
    @EJB
    DisponibilityServiceLocal disponibiliteSrv;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Lieu> lieux = lieuSrv.getAll();
        req.setAttribute("lieux", lieux);

        List<Personnel> formateurs = personnelSrv.getAllFormateurs();
        req.setAttribute("formateurs", formateurs);

        List<Vehicule> vehicules = vehiculeSrv.getAll();
        req.setAttribute("vehicules", vehicules);

        List<TypeSessionPratique> types = typeSrv.getAll();
        req.setAttribute("types", types);

        RequestDispatcher rq = req.getRequestDispatcher("addSession.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateString = req.getParameter("date");
        String debutString = req.getParameter("debut");
        String dureeString = req.getParameter("duree");
        String nbPlacesString = req.getParameter("nbPlaces");

        String placeIdString = req.getParameter("placeId");
        String intervenantIdString = req.getParameter("intervenantId");

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");


        try {
            long intervenantId = Long.parseLong(intervenantIdString);
            Personnel pers = personnelSrv.getById(intervenantId);

            int debut = Integer.parseInt(debutString);
            int duree = Integer.parseInt(dureeString);

            Date date = sdf.parse(dateString);

            //on teste si le formateur est dispo à la date
            Disponibility d = this.getDisponibility(pers, date, debut, duree);

            System.out.println(d);

            if (d != null) {

                System.out.println("Il y a une disponibilite");

                this.manageDisponibility(d, date, debut, duree);

                int nbPlaces = Integer.parseInt(nbPlacesString);

                long placeId = Long.parseLong(placeIdString);
                Lieu l = lieuSrv.getById(placeId);

                SessionFormation s = new SessionFormation();
                s.setDate(date);
                s.setDure(duree);
                s.setHeureDebut(debut);
                s.setIntervenant(pers);
                s.setLieu(l);
                s.setNbrMaxPlace(nbPlaces);


                String typeSession = req.getParameter("typeSession");

                if (typeSession.equals("pratique")) {

                    String vehiculeIdString = req.getParameter("vehiculeId");
                    String typeIdString = req.getParameter("typeId");

                    long vehiculeId = Long.parseLong(vehiculeIdString);
                    Vehicule v = vehiculeSrv.getById(vehiculeId);

                    long typeId = Long.parseLong(typeIdString);
                    TypeSessionPratique t = typeSrv.getById(typeId);

                    Pratique p = new Pratique(s);
                    p.setType(t);
                    p.setVehicule(v);

                    pratiqueSrv.add(p);

                } else {
                    String difficultString = req.getParameter("difficult");
                    int difficult = Integer.parseInt(difficultString);

                    Theorique t = new Theorique(s);
                    t.setDifficulte(difficult);

                    theoriqueSrv.add(t);
                }
            } else {
                System.out.println("IL n'ya pas de disponibilité");
            }
        } catch (Exception e) {
        }
    }

    private Disponibility getDisponibility(Personnel pers, Date date, int debut, int duree) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, debut);

        Date dateDebut = cal.getTime();

        cal.add(Calendar.HOUR, duree);

        Date dateFin = cal.getTime();

        System.out.println("Date Debut " + dateDebut);
        System.out.println("Date Fin " + dateFin);

        System.out.println("coucou");

        return disponibiliteSrv.getForUserAtDate(pers, dateDebut, dateFin);
    }

    private void manageDisponibility(Disponibility dispo, Date date, int debut, int duree) {
        System.out.println("Coucou " + date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, debut);

        Date dateDebut = cal.getTime();

        cal.add(Calendar.HOUR, duree);

        Date dateFin = cal.getTime();

        if (dispo.getDateDebut().equals(dateDebut)) {
            if (dispo.getDateFin().equals(dateFin)) {
                disponibiliteSrv.remove(dispo);
            } else {
                dispo.setDateDebut(dateFin);
                disponibiliteSrv.refresh(dispo);
            }
        } else {
            if (dispo.getDateFin().equals(dateFin)) {
                dispo.setDateFin(dateDebut);
                disponibiliteSrv.refresh(dispo);
            } else {
                Disponibility newDispo = new Disponibility();
                newDispo.setFormateur(dispo.getFormateur());
                newDispo.setDateDebut(dateFin);
                newDispo.setDateFin(dispo.getDateFin());
                disponibiliteSrv.add(newDispo);

                dispo.setDateFin(dateDebut);
                disponibiliteSrv.refresh(dispo);

            }
        }
    }
}
