/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Personnel;
import com.safedriving.services.InscritForumServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
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
public class EmployeDetailServlet extends HttpServlet {

    @EJB
    PersonnelServiceLocal srvEmploye;
    @EJB
    InscritForumServiceLocal srvInscri;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Personnel pers = srvEmploye.getById(id);
        try {
            req.setAttribute("compteWeb", srvInscri.getByUsername(pers.getCompteForum().getUsername()));
        } catch (Exception e) {
            req.setAttribute("compteWeb", null);
        }
        try {
            if (req.getParameter("changeCompteWeb").equals("true")) {
                System.out.println("entré if");
                req.setAttribute("employe", pers);
                req.getRequestDispatcher("addCompteWeb.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println("entré catch");
            req.setAttribute("employe", pers);
            req.getRequestDispatcher("employeDetail.jsp").forward(req, resp);
        }

    }
}
