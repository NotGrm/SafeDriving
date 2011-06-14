/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.InscritForum;
import com.safedriving.services.InscritForumServiceLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ehres
 */
public class LoginServlet extends HttpServlet {

    @EJB
    private InscritForumServiceLocal srv;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userEntry;
        InscritForum userDb;
        String password;

        HttpSession session = req.getSession();
        userEntry = req.getParameter("username");
        password = req.getParameter("password");
        try {
            userDb = srv.getByUsernamePwd(userEntry, password);
            session.setAttribute("user", userDb);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Entré Catch");
            resp.sendRedirect("Login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }
}
