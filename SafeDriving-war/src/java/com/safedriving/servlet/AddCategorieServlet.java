/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.blog.Categorie;
import com.safedriving.services.CategorieServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class AddCategorieServlet extends HttpServlet {

    @EJB
    CategorieServiceLocal srv;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Categorie> L = srv.getAllCategorie();
        req.setAttribute("categories", L);

        RequestDispatcher rq = req.getRequestDispatcher("addCategorie.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String categorieName = req.getParameter("categorieName");
        long parentId = Long.parseLong(req.getParameter("parent"));

        Categorie cat = new Categorie();
        cat.setName(categorieName);

        if (parentId != 0) {
            Categorie parent = srv.getById(parentId);
            
            if(parent.getChildren() == null) {
                parent.setChildren(new ArrayList<Categorie>());
            }
            
            parent.getChildren().add(cat);
            
            cat.setParent(parent);
            
            //srv.addCategorie(cat);
            
            srv.modifierCategorie(parent);

        } else {


            srv.addCategorie(cat);
        }
        
        req.setAttribute("message", "Catégorie ajouté !");
        req.getRequestDispatcher("/SafeDriving-war/AddCategorie").forward(req, resp);
    }
}
