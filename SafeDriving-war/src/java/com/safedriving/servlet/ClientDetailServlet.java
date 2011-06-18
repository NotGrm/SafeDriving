/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Client;
import com.safedriving.model.InscritForum;
import com.safedriving.services.ClientServiceLocal;
import com.safedriving.services.InscritForumServiceLocal;
import com.safedriving.services.WebSiteRoleServiceLocal;
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
    private ClientServiceLocal srvClient;
    @EJB
    private InscritForumServiceLocal srvCompteWeb;
    @EJB
    private WebSiteRoleServiceLocal srvRole;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client cli = new Client();
        cli.setId(Long.parseLong(req.getParameter("id")));
        cli.setNom(req.getParameter("nom"));
        cli.setPrenom(req.getParameter("prenom"));        
        //cli.setDateNaissance();
        cli.setAdresse(req.getParameter("adresse"));
        cli.setCodePostal(Integer.parseInt(req.getParameter("codePostal")));
        cli.setVille(req.getParameter("ville"));
        srvClient.refresh(cli);
        
        resp.sendRedirect("/SafeDriving-war/auth/ClientDetail?id=" + cli.getId());
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Client cli = srvClient.getById(id);
        
        try{
            System.out.println("modification demandé");
            req.getParameter("modif").equals("true");                
            req.setAttribute("modif", true);
        }catch(Exception e){
            System.out.println("pas de modification demandé");
        }

        if (req.getParameter("addcompteweb") != null) {
            req.setAttribute("roles", srvRole.getAll());
            req.setAttribute("client", cli);
            req.getRequestDispatcher("addCompteWeb.jsp").forward(req, resp);
        } else {

            req.setAttribute("compte", cli.getCompteForum());
            req.setAttribute("client", cli);
            req.getRequestDispatcher("clientDetail.jsp").forward(req, resp);
        }

    }
}
