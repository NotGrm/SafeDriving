/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.model.Pratique;
import com.safedriving.model.TypeSessionPratique;
import com.safedriving.model.Vehicule;
import com.safedriving.services.LieuServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.PratiqueServiceLocal;
import com.safedriving.services.TypeSessionPratiqueServiceLocal;
import com.safedriving.services.VehiculeServiceLocal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Grm
 */
public class AddSessionPratiqueServlet extends HttpServlet {

    @EJB
    PratiqueServiceLocal srv;
    
    @EJB
    LieuServiceLocal srvLieu;
    
    @EJB
    PersonnelServiceLocal srvPersonnel;
    
    @EJB
    VehiculeServiceLocal srvVehicule;
    
    @EJB
    TypeSessionPratiqueServiceLocal srvTypePratique;
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("formateurs", srvPersonnel.getAll());
        req.getRequestDispatcher("addSessionPratique.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int nbPlaces = Integer.parseInt(req.getParameter("nbPlaces"));
        String dateString = req.getParameter("date");
        String placeName = req.getParameter("place");
        String codePersonnel = req.getParameter("intervenant");
        String vehiculeNumSerie = req.getParameter("vehiculeNumSerie");
        String typePratiqueName = req.getParameter("type");
        int duree = Integer.parseInt(req.getParameter("duree"));
        int heureDebut = Integer.parseInt(req.getParameter("heureDebut"));
        
        Lieu l = srvLieu.getByNom(placeName);
        Personnel p = srvPersonnel.getByCodePersonnel(codePersonnel);
        Vehicule v = srvVehicule.getByNumSerie(vehiculeNumSerie);
        TypeSessionPratique t = srvTypePratique.getByTypeName(typePratiqueName);
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date date = null;
        try {
            date = sdf.parse(dateString);
            
        } catch (ParseException ex) {
            Logger.getLogger(AddExamenServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Pratique pratique = new Pratique();
        pratique.setDate(date);
        pratique.setDure(duree);    
        pratique.setHeureDebut(heureDebut);
        pratique.setIntervenant(p);
        pratique.setLieu(l);
        pratique.setNbrMaxPlace(nbPlaces);
        pratique.setType(t);
        pratique.setVehicule(v);
        
        srv.add(pratique);
        
        resp.sendRedirect("/SafeDriving-war/auth/AddSessionPratique");
    }
}
