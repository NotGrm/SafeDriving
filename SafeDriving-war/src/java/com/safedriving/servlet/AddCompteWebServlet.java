/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Client;
import com.safedriving.model.InscritForum;
import com.safedriving.model.WebSiteRole;
import com.safedriving.services.ClientServiceLocal;
import com.safedriving.services.InscritForumServiceLocal;
import com.safedriving.services.WebSiteRoleService;
import com.safedriving.services.WebSiteRoleServiceLocal;
import java.io.IOException;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
                role = srvRole.getByRoleName("FORUM");
                compte.setUsername(username);
                compte.setPassword(password);
                compte.setRole(role);
                srvCompteWeb.add(compte);
            }
            cli.setCompteForum(compte);
            srvClient.refresh(cli);
            resp.sendRedirect("/SafeDriving-war/");

        } catch (Exception e) {
            req.setAttribute("error", "mauvais pseudo");
            req.getRequestDispatcher("addCompteWeb.jsp").forward(req, resp);
        }

    }
}
