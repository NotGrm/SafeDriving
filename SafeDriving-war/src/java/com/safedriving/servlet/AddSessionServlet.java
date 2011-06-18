/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.model.Pratique;
import com.safedriving.model.SessionFormation;
import com.safedriving.model.Theorique;
import com.safedriving.model.TypeSessionPratique;
import com.safedriving.model.Vehicule;
import com.safedriving.services.LieuServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.PratiqueServiceLocal;
import com.safedriving.services.TheoriqueServiceLocal;
import com.safedriving.services.TypeSessionPratiqueServiceLocal;
import com.safedriving.services.VehiculeServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
            Date date = sdf.parse(dateString);
            int debut = Integer.parseInt(debutString);
            int duree = Integer.parseInt(dureeString);
            int nbPlaces = Integer.parseInt(nbPlacesString);

            long placeId = Long.parseLong(placeIdString);
            Lieu l = lieuSrv.getById(placeId);

            long intervenantId = Long.parseLong(intervenantIdString);
            Personnel pers = personnelSrv.getById(intervenantId);

            SessionFormation s = new SessionFormation();
            s.setDate(date);
            s.setDure(duree);
            s.setHeureDebut(debut);
            s.setIntervenant(pers);
            s.setLieu(l);
            s.setNbrMaxPlace(nbPlaces);


            String typeSession = req.getParameter("typeSession");

            System.out.println(typeSession);
            
            if (typeSession.equals("pratique")) {
                                
                String vehiculeIdString = req.getParameter("vehiculeId");
                String typeIdString = req.getParameter("typeId");

                long vehiculeId = Long.parseLong(vehiculeIdString);
                Vehicule v = vehiculeSrv.getById(vehiculeId);
                
                long typeId = Long.parseLong(typeIdString);
                TypeSessionPratique t = typeSrv.getById(typeId);

                System.out.println(s.getHeureDebut());
                
                Pratique p = new Pratique(s);
                System.out.println("cocu");
                System.out.println("Coucou" + p.getHeureDebut());
                p.setType(t);
                p.setVehicule(v);

                pratiqueSrv.add(p);

            } else {
                System.out.println("on est dans theorique");
                String difficultString = req.getParameter("difficult");
                int difficult = Integer.parseInt(difficultString);

                Theorique t = new Theorique(s);
                t.setDifficulte(difficult);

                theoriqueSrv.add(t);
            }

        } catch (Exception e) {
        }

    }
}
