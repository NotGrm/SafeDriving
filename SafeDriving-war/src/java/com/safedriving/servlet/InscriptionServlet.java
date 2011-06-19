/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.InscritForum;
import com.safedriving.services.InscritForumServiceLocal;
import com.safedriving.services.WebSiteRoleServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class InscriptionServlet extends HttpServlet {

    @EJB
    InscritForumServiceLocal srv;
    @EJB
    WebSiteRoleServiceLocal srvRole;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("inscription.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            InscritForum inscrit = new InscritForum();
            inscrit.setUsername(username);
            inscrit.setPassword(password);
            inscrit.setRole(srvRole.getByRoleName("CLIENT"));
            inscrit.setDateInscription(new Date());

            srv.add(inscrit);
            req.setAttribute("InscriptionStatus", true);
        } catch (Exception e) {
            req.setAttribute("InscriptioStatus", false);
        }

        req.getRequestDispatcher("inscription.jsp").forward(req, resp);

    }
}
