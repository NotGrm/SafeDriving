/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Lieu;
import com.safedriving.services.LieuServiceLocal;
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
public class AddLieuServlet extends HttpServlet {

    @EJB
    LieuServiceLocal srv;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("addLieu.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String zipcode = req.getParameter("zipcode");
        String city = req.getParameter("city");
        
        Lieu l = new Lieu();
        l.setNom(name);
        l.setAdresse(address);
        l.setCodePostal(zipcode);
        l.setVille(city);
        
        getServletContext().log(""+l);
        
        srv.add(l);
        
    }
    
    
}
