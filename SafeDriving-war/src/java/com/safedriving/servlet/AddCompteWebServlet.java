/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Client;
import com.safedriving.model.InscritForum;
import com.safedriving.model.Personnel;
import com.safedriving.model.WebSiteRole;
import com.safedriving.services.ClientServiceLocal;
import com.safedriving.services.InscritForumServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.WebSiteRoleService;
import com.safedriving.services.WebSiteRoleServiceLocal;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ehres
 */
public class AddCompteWebServlet extends HttpServlet {

    @EJB
    InscritForumServiceLocal srvCompteWeb;
    @EJB
    WebSiteRoleServiceLocal srvRole;
    @EJB
    ClientServiceLocal srvClient;
    @EJB
    PersonnelServiceLocal srvPersonnel;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("employe") != null) {
            System.out.println("entré if employe");
            Personnel pers = new Personnel();
            String username;
            String password;            
            int persId;
            WebSiteRole role;
            InscritForum compte = new InscritForum();
            persId = Integer.parseInt(req.getParameter("employe"));
            pers = srvPersonnel.getById(persId);

            try {
                if (req.getParameter("bool").equals("yes")) {
                    username = req.getParameter("pseudoSearch");
                    compte = srvCompteWeb.getByUsername(username);

                } else if (req.getParameter("bool").equals("no")) {
                    username = req.getParameter("pseudoAdd");
                    password = req.getParameter("password");
                    role = srvRole.getByRoleName(req.getParameter("role"));
                    compte.setUsername(username);
                    compte.setPassword(password);
                    compte.setRole(role);
                    compte.setDateInscription(new Date());
                    srvCompteWeb.add(compte);
                }
                pers.setCompteForum(compte);
                srvPersonnel.refresh(pers);
                resp.sendRedirect("/SafeDriving-war/");

            } catch (Exception e) {
                req.setAttribute("employe", pers);
                req.setAttribute("error", "mauvais pseudo");
                req.getRequestDispatcher("addCompteWeb.jsp").forward(req, resp);
            }
        } else if (req.getParameter("client") != null) {
            System.out.println("entré if client");
            Client cli = new Client();
            String username;
            String password;
            int clientId;
            WebSiteRole role;
            InscritForum compte = new InscritForum();
            clientId = Integer.parseInt(req.getParameter("client"));
            cli = srvClient.getById(clientId);

            try {
                if (req.getParameter("bool").equals("yes")) {
                    username = req.getParameter("pseudoSearch");
                    compte = srvCompteWeb.getByUsername(username);

                } else if (req.getParameter("bool").equals("no")) {
                    username = req.getParameter("pseudoAdd");
                    password = req.getParameter("password");
                    role = srvRole.getByRoleName(req.getParameter("role"));
                    compte.setUsername(username);
                    compte.setPassword(password);
                    compte.setRole(role);
                    compte.setDateInscription(new Date());
                    srvCompteWeb.add(compte);
                }
                cli.setCompteForum(compte);
                srvClient.refresh(cli);
                resp.sendRedirect("/SafeDriving-war/");

            } catch (Exception e) {
                req.setAttribute("client", cli);
                req.setAttribute("error", "mauvais pseudo");
                req.getRequestDispatcher("addCompteWeb.jsp").forward(req, resp);
            }
        }
    }
}
