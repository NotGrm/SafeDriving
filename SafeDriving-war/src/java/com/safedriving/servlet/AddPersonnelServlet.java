/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Personnel;
import com.safedriving.services.PersonnelServiceLocal;
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
public class AddPersonnelServlet extends HttpServlet {

    @EJB
    private PersonnelServiceLocal srv;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        RequestDispatcher rq = request.getRequestDispatcher("addPersonnel.jsp");
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String firstname = request.getParameter("firstname");
        String address = request.getParameter("address");
        int zipcode = Integer.parseInt(request.getParameter("zipcode"));
        String city = request.getParameter("city");
        String code = request.getParameter("code");
        
        Personnel pers = new Personnel();
        pers.setNom(name);
        pers.setPrenom(firstname);
        pers.setAdresse(address);
        pers.setCodePostal(zipcode);
        pers.setVille(city);
        pers.setCodePersonnel(code);
        
        
        srv.add(pers);
    }

    
}
