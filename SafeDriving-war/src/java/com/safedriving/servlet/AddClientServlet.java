/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Client;
import com.safedriving.model.Formation;
import com.safedriving.model.InscritForum;
import com.safedriving.services.ClientServiceLocal;
import com.safedriving.services.InscritForumServiceLocal;
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
public class AddClientServlet extends HttpServlet {

    @EJB
    ClientServiceLocal srv;
    
    @EJB
    InscritForumServiceLocal srvForum;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("addClient.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String firstname = req.getParameter("firstname");
        String address = req.getParameter("address");
        int zipcode = Integer.parseInt(req.getParameter("zipcode"));
        String city = req.getParameter("city");
        long clientNumber = Long.parseLong(req.getParameter("clientNumber"));
        String accountName = req.getParameter("accountName");
        
        InscritForum inscrit = srvForum.getByUsername(accountName);
        
        Client cli = new Client();
        cli.setNom(name);
        cli.setPrenom(firstname);
        cli.setAdresse(address);
        cli.setCodePostal(zipcode);
        cli.setVille(city);
        cli.setNumClient(clientNumber);
        cli.setCompteForum(inscrit);
        cli.setFormation(new Formation());
        
        srv.addClient(cli);
        
        
    }

    
}
