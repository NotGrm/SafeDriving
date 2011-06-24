/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.InscritForum;
import com.safedriving.model.Personnel;
import com.safedriving.model.blog.Article;
import com.safedriving.model.blog.Categorie;
import com.safedriving.model.blog.Tag;
import com.safedriving.services.ArticleServiceLocal;
import com.safedriving.services.CategorieServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.TagServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Grm
 */
public class ArticleServlet extends HttpServlet {

    @EJB
    private ArticleServiceLocal srv;
    @EJB
    private PersonnelServiceLocal srvPersonnel;
    @EJB
    private CategorieServiceLocal srvCategorie;
    @EJB
    private TagServiceLocal srvTag;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        List<Categorie> L = srvCategorie.getAllTopLevelCategorie();
        req.setAttribute("categories", L);

        List<Tag> Ltag = srvTag.getAllTag();
        req.setAttribute("tags", Ltag);

        RequestDispatcher rq = req.getRequestDispatcher("article.jsp");

        if (method.equals("new")) {
            rq.forward(req, resp);
        } else {

            long id = Long.parseLong(req.getParameter("id"));
            Article art = srv.getById(id);

            if (method.equals("edit")) {
                req.setAttribute("article", art);

                rq.forward(req, resp);
            }
            if (method.equals("delete")) {
                srv.remove(art);
                resp.sendRedirect("/SafeDriving-war/Home");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        String tags = req.getParameter("tags");

        Article art = new Article();

        String[] categories = req.getParameterValues("selectedCategories");
        for (String categorie : categories) {
            long id = Long.parseLong(categorie);

            Categorie c = srvCategorie.getById(id);

            if (art.getCategories() == null) {
                art.setCategories(new ArrayList<Categorie>());
            }

            art.getCategories().add(c);
        }

        HttpSession session = req.getSession();
        InscritForum i = (InscritForum) session.getAttribute("user");

        Personnel p = srvPersonnel.getByCompteForum(i);

        art.setTitre(title);
        art.setText(text);
        //art.setTag(tags);
        art.setDatePublication(new Date());
        art.setAuteur(p);

        String idString = req.getParameter("id");
        System.err.print(idString);
        if (idString.equals("")) {
            srv.add(art);
        } else {
            long id = Long.parseLong(idString);
            art.setId(id);
            srv.refresh(art);
        }

        resp.sendRedirect("/SafeDriving-war/Home");
    }
}
