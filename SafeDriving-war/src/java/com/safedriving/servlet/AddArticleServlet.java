/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Personnel;
import com.safedriving.model.blog.Article;
import com.safedriving.model.blog.Categorie;
import com.safedriving.model.blog.Tag;
import com.safedriving.services.ArticleServiceLocal;
import com.safedriving.services.CategorieServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.TagServiceLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
public class AddArticleServlet extends HttpServlet {

    @EJB
    private ArticleServiceLocal srv;
    
    @EJB
    private PersonnelServiceLocal srvPersonnel;
    
    @EJB
    private CategorieServiceLocal srvCategorie;
    
    @EJB
    private TagServiceLocal srvTag;

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
        
        List<Categorie> L = srvCategorie.getAllTopLevelCategorie();
        request.setAttribute("categories", L);
        
        List<Tag> Ltag = srvTag.getAllTag();
        request.setAttribute("tags", Ltag);
        
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
        String author = request.getParameter("author");
        String tags = request.getParameter("tags");
        
        Article art = new Article();
        
        /*String[] categories = request.getParameterValues("selectedCategories");
        for (String categorie : categories) {
            long id = Long.parseLong(categorie);
            
            System.err.print(id);
            
            Categorie c = srvCategorie.getById(id);
            
            if(art.getCategories() == null)
                art.setCategories(new ArrayList<Categorie>());
            
            art.getCategories().add(c);
        }*/
        
        Personnel pers = srvPersonnel.getByCodePersonnel(author);
        
        
        art.setTitre(title);
        art.setText(text);
        //art.setTag(tags);
        art.setDatePublication(new Date());
        art.setAuteur(pers);
        
        srv.add(art);
        
        response.sendRedirect("/safeDriving-war/Home");
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
