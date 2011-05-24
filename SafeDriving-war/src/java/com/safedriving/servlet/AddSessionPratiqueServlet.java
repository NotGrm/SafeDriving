/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.model.TypeSessionPratique;
import com.safedriving.model.Vehicule;
import com.safedriving.services.LieuServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.PratiqueServiceLocal;
import com.safedriving.services.TypeSessionPratiqueServiceLocal;
import com.safedriving.services.VehiculeServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        RequestDispatcher rq = req.getRequestDispatcher("addSessionPratique.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int nbPlaces = Integer.parseInt(req.getParameter("nbPlaces"));
        String dateString = req.getParameter("date");
        String placeName = req.getParameter("place");
        String codePersonnel = req.getParameter("intervenant");
        String vehiculeName = req.getParameter("vehiculeName");
        String typePratiqueName = req.getParameter("type");
        
        Lieu l = srvLieu.getByNom(placeName);
        Personnel p = srvPersonnel.getByCodePersonnel(codePersonnel);
        Vehicule v = srvVehicule.getByName(vehiculeName);
        TypeSessionPratique t = srvTypePratique.getByName(typePratiqueName);
        
        Date date = null;
        try {
            date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH).parse(dateString);
            
        } catch (ParseException ex) {
            Logger.getLogger(AddExamenServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
