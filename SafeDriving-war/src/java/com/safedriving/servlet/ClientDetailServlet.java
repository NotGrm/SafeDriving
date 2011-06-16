/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Client;
import com.safedriving.services.ClientServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ehres
 */
public class ClientDetailServlet extends HttpServlet {

    @EJB
    ClientServiceLocal srvClient;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("id"));
        Client cli = srvClient.getById(id);
        req.setAttribute("client", cli);
        req.getRequestDispatcher("clientDetail.jsp").forward(req, resp);
    }

   
}
