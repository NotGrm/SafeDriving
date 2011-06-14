/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Client;
import com.safedriving.services.ClientServiceLocal;
import com.safedriving.services.InscritForumServiceLocal;
import java.io.IOException;
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


        String name = null;
        String firstname = null;
        String address = null;
        String city = null;
        String accountName = null;
        int zipcode = 0;
        long clientNumber = 0;

        try {
            name = req.getParameter("name");
            firstname = req.getParameter("firstname");
            address = req.getParameter("address");
            zipcode = Integer.parseInt(req.getParameter("zipcode"));
            city = req.getParameter("city");
            clientNumber = Long.parseLong(req.getParameter("clientNumber"));
            accountName = null;
            Client cli = new Client();
            cli.setNom(name);
            cli.setPrenom(firstname);
            cli.setAdresse(address);
            cli.setCodePostal(zipcode);
            cli.setVille(city);
            cli.setNumClient(clientNumber);
            System.out.println("avant ajout client!");
            srv.add(cli);
            System.out.println("après ajout client!");                 
            req.setAttribute("client", cli);
            req.getRequestDispatcher("addCompteWeb.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", "Erreur dans l'ajout du client");
            req.getRequestDispatcher("addClient.jsp").forward(req, resp);
        }



    }
}
