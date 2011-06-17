/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.services.LieuServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.PratiqueServiceLocal;
import com.safedriving.services.TheoriqueServiceLocal;
import com.safedriving.services.VehiculeServiceLocal;
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
public class AddSessionServlet extends HttpServlet {

    @EJB
    PratiqueServiceLocal pratiqueSrv;
    
    @EJB
    TheoriqueServiceLocal theoriqueSrv;
    
    @EJB
    PersonnelServiceLocal personnelSrv;
    
    @EJB
    LieuServiceLocal lieuSrv;
    
    @EJB
    VehiculeServiceLocal vehiculeSrv;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Lieu> lieux = lieuSrv.getAll();
        req.setAttribute("lieux", lieux);
        
        List<Personnel> formateurs = personnelSrv.getAllFormateurs();
        req.setAttribute("formateurs", formateurs);
        
        RequestDispatcher rq = req.getRequestDispatcher("addSession.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    
}
