/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.InscritForum;
import com.safedriving.model.Personnel;
import com.safedriving.model.WebSiteRole;
import com.safedriving.services.InscritForumServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.WebSiteRoleServiceLocal;
import java.io.IOException;
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
    private PersonnelServiceLocal srvEmploye;
    @EJB
    private InscritForumServiceLocal srvCompte;
    @EJB
    private WebSiteRoleServiceLocal srvRole;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Personnel pers = new Personnel();
        Long idRole;
        InscritForum compte;
        WebSiteRole role;
        
        //try {
            idRole = Long.parseLong(req.getParameter("roles"));
            pers = srvEmploye.getById(Long.parseLong(req.getParameter("id")));
            pers.setNom(req.getParameter("nom"));
            pers.setPrenom(req.getParameter("prenom"));
            //cli.setDateNaissance();
            pers.setAdresse(req.getParameter("adresse"));
            pers.setCodePostal(Integer.parseInt(req.getParameter("codePostal")));
            pers.setVille(req.getParameter("ville"));
            System.out.println("test 1");
            compte = pers.getCompteForum();
            System.out.println("test 2 + idRole : " + idRole + "compte idforum : " + pers.getCompteForum().getId());
            role = srvRole.getById(idRole);
            System.out.println("role.id : " + role.getId() + " roleName : " + role.getRoleName());
            compte.setRole(role);
            System.out.println("test");
            srvCompte.refresh(compte);
            System.out.println("prout");
            srvEmploye.refresh(pers);

            resp.sendRedirect("/SafeDriving-war/auth/EmployeDetail?id=" + pers.getId());
       /* } catch (Exception e) {
            System.out.println("catch" + e.getMessage());
            req.setAttribute("message", "La modification n'a pas fonctionné !");
            req.setAttribute("id", pers.getId());
            req.getRequestDispatcher("/SafeDriving-war/auth/EmployeDetail").forward(req, resp);
        }*/
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Personnel pers = srvEmploye.getById(id);

        try {
            if (req.getParameter("modif").equals("true")) {
                req.setAttribute("modif", true);
                req.setAttribute("roles", srvRole.getAll());
                System.out.println("modification demandé");
            }
        } catch (Exception e) {
            System.out.println("pas de modification demandé");
        }

        if (req.getParameter("addcompteweb") != null) {
            req.setAttribute("roles", srvRole.getAll());
            req.setAttribute("employe", pers);
            req.getRequestDispatcher("addCompteWeb.jsp").forward(req, resp);
        } else {

            req.setAttribute("compte", pers.getCompteForum());
            req.setAttribute("employe", pers);
            req.getRequestDispatcher("employeDetail.jsp").forward(req, resp);
        }

    }
}
