/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.model.Theorique;
import com.safedriving.services.LieuServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.TheoriqueServiceLocal;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class AddSessionTheoriqueServlet extends HttpServlet {
    
    @EJB
    LieuServiceLocal srvLieu;
    
    @EJB
    PersonnelServiceLocal srvPersonnel;
    
    @EJB
    TheoriqueServiceLocal srvTheorique;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("addSessionTheorique.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nbPlaces = Integer.parseInt(req.getParameter("nbPlaces"));
        String dateString = req.getParameter("date");
        String placeName = req.getParameter("place");
        String codePersonnel = req.getParameter("intervenant");
        int dificulte = Integer.parseInt(req.getParameter("difficult"));
        int duree = Integer.parseInt(req.getParameter("duree"));
        int heure = Integer.parseInt(req.getParameter("debut"));
        System.out.println("date : " + dateString);
        
        Theorique t = new Theorique();        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date date = null;
        Lieu l = srvLieu.getByNom(placeName);
        Personnel p = srvPersonnel.getByCodePersonnel(codePersonnel);
        
        try {
            date = sdf.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(AddSessionTheoriqueServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        t.setDifficulte(dificulte);
        t.setDate(date);
        t.setDure(duree);
        t.setIntervenant(p);
        t.setNbrMaxPlace(nbPlaces);
        t.setLieu(l);
        t.setHeureDebut(heure);
        
        srvTheorique.add(t);
        
        resp.sendRedirect("/SafeDriving-war/auth/AddSessionTheorique");
        
    }
    
    
}
