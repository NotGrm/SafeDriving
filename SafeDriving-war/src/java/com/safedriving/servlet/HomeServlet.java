/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.blog.Article;
import com.safedriving.services.ArticleServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
public class HomeServlet extends HttpServlet {


    @EJB
    ArticleServiceLocal srv;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles;
        
        articles = srv.getAll();
        
        req.setAttribute("articles", articles);

        RequestDispatcher rq = req.getRequestDispatcher("index.jsp");
        rq.forward(req, resp);
    }
    
}
  

