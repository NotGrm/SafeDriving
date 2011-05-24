/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Vehicule;
import com.safedriving.services.VehiculeServiceLocal;
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
public class AddVehiculeServlet extends HttpServlet {

    @EJB
    VehiculeServiceLocal srv;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("addVehicule.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String serialNumber = req.getParameter("serialNumber");
        String plaque = req.getParameter("plaque");
        String date = req.getParameter("dateAchat");
        
        Vehicule v = new Vehicule();
        v.setNumSerie(serialNumber);
        v.setPlaque(plaque);
        v.setDateAchat(date);
        
        srv.add(v);
    }

    
}
