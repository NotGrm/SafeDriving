/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.TypeSessionPratique;
import com.safedriving.services.TypeSessionPratiqueServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AddTypePratiqueServlet extends HttpServlet {

    @EJB
    TypeSessionPratiqueServiceLocal srv;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("addTypePratique.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        int nbParticipants = Integer.parseInt(req.getParameter("nb"));
        
        TypeSessionPratique t = new TypeSessionPratique();
        t.setTypeName(name);
        t.setMaxAvailablePlaces(nbParticipants);
        
        srv.add(t);
    }
    
    
}