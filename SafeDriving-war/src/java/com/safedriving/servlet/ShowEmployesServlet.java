/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Personnel;
import com.safedriving.services.PersonnelServiceLocal;
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
public class ShowEmployesServlet extends HttpServlet {

    
    @EJB
    PersonnelServiceLocal srvEmploye;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showEmployes");
        List<Personnel> pers = srvEmploye.getAll();
        System.out.println("pers.size : " + pers.size());
        req.setAttribute("employes", pers);
        req.getRequestDispatcher("showEmployes.jsp").forward(req, resp);
    }

    
}
