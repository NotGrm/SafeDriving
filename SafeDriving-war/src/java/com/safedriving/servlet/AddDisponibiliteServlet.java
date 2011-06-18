/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Disponibility;
import com.safedriving.model.InscritForum;
import com.safedriving.model.Personnel;
import com.safedriving.services.DisponibilityServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Grm
 */
public class AddDisponibiliteServlet extends HttpServlet {

    @EJB
    DisponibilityServiceLocal srv;
    
    @EJB
    PersonnelServiceLocal personnelSrv;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("addDisponibilite.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateDebutString = req.getParameter("dateDebut");
        String heureDebutString = req.getParameter("heureDebut");
        String dateFinString = req.getParameter("dateFin");
        String heureFinString = req.getParameter("heureFin");
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Calendar cal = Calendar.getInstance(Locale.FRENCH);
        try {            
            Date dateDebut = sdf.parse(dateDebutString);
            int heureDebut = Integer.parseInt(heureDebutString);
            
            cal.setTime(dateDebut);
            cal.set(Calendar.HOUR, heureDebut);
            
            Date fullDateDebut = cal.getTime();
            
            
            Date dateFin = sdf.parse(dateFinString);
            int heureFin = Integer.parseInt(heureFinString);
            
            cal.setTime(dateFin);
            cal.set(Calendar.HOUR, heureFin);
            
            Date fullDateFin = cal.getTime();
            
            HttpSession session = req.getSession();
            InscritForum i = (InscritForum)session.getAttribute("user");
            
            Personnel p = personnelSrv.getByCompteForum(i);
            
            Disponibility d = new Disponibility();
            d.setDateDebut(fullDateDebut);
            d.setDateFin(fullDateFin);
            d.setFormateur(p);
            
            srv.add(d);
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
    
    
}
