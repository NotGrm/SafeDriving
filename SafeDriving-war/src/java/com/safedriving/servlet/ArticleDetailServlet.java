/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Article;
import com.safedriving.services.ArticleServiceLocal;
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
public class ArticleDetailServlet extends HttpServlet {

    @EJB
    ArticleServiceLocal srv;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        
        PrintWriter writer = resp.getWriter();
        
        Article art = srv.getById(id);
        
        req.setAttribute("article", art);
        
        RequestDispatcher rq = req.getRequestDispatcher("articleDetail.jsp");
        rq.forward(req, resp);
    }

}
