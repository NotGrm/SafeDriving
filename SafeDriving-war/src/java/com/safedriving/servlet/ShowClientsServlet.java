/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Client;
import com.safedriving.services.ClientServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ehres
 */
public class ShowClientsServlet extends HttpServlet {

    @EJB 
    ClientServiceLocal srvClient;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showClients");
        List<Client> clients = srvClient.getAll();
        req.setAttribute("clients", clients);
        req.getRequestDispatcher("showClients.jsp").forward(req, resp);
    }
   
}
