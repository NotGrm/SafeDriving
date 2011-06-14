/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Examen;
import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.model.TypeExamen;
import com.safedriving.services.ExamenServiceLocal;
import com.safedriving.services.LieuServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.TypeExamenServiceLocal;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AddExamenServlet extends HttpServlet {

    @EJB
    ExamenServiceLocal srv;
    
    @EJB
    TypeExamenServiceLocal srvType;
    
    @EJB
    PersonnelServiceLocal srvPersonnel;
    
    @EJB
    LieuServiceLocal srvLieu;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<TypeExamen> Ltype = srvType.getAll();
        req.setAttribute("types", Ltype);
        
        RequestDispatcher rq = req.getRequestDispatcher("addExamen.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int places = Integer.parseInt(req.getParameter("nbPlaces"));
        String dateString = req.getParameter("date");
        String placeName = req.getParameter("place");
        String code = req.getParameter("intervenant");
        long type = Long.parseLong(req.getParameter("type"));
        
        TypeExamen typeEx = srvType.getById(type);
        Personnel pers = srvPersonnel.getByCodePersonnel(code);
        Lieu lieu = srvLieu.getByNom(placeName);
        
        Date date = null;
        try {
            date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH).parse(dateString);
            
        } catch (ParseException ex) {
            Logger.getLogger(AddExamenServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        Examen ex = new Examen();
        ex.setDate(date);
        ex.setTypeExamen(typeEx);
        ex.setIntervenant(pers);
        ex.setNbrMaxPlace(places);
        ex.setLieu(lieu);
        
        srv.add(ex);
        
    }

    
}
