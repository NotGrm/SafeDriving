/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Article;
import com.safedriving.model.Personnel;
import com.safedriving.services.ArticleServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import java.io.IOException;
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
public class AddArticleServlet extends HttpServlet {

    @EJB
    private ArticleServiceLocal srv;
    
    @EJB
    private PersonnelServiceLocal srvPersonnel;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rq = request.getRequestDispatcher("addArticle.jsp");
        rq.forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        String categorie = request.getParameter("categorie");
        String author = request.getParameter("author");
        String tags = request.getParameter("tags");
        
        Personnel pers = srvPersonnel.getByCodePersonnel(author);
        
        Article art = new Article();
        art.setTitre(title);
        art.setText(text);
        art.setCategorie(categorie);
        art.setTag(tags);
        art.setDatePublication(new Date());
        art.setAuteur(pers);
        
        srv.add(art);
        
        //srv = new ArticleService();
        //srv.addArticle(art);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
