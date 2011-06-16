/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Client;
import com.safedriving.model.InscritForum;
import com.safedriving.model.Pratique;
import com.safedriving.model.SessionFormation;
import com.safedriving.model.Theorique;
import com.safedriving.services.PersonneServiceLocal;
import com.safedriving.services.SessionFormationServiceLocal;
import com.safedriving.services.participationSessionServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
public class RegisterToSessionServlet extends HttpServlet {

    @EJB
    SessionFormationServiceLocal srv;
    
    @EJB
    PersonneServiceLocal personneSrv;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<SessionFormation> Lsession = srv.getFutureSession(new Date());

        req.setAttribute("Lsession", Lsession);

        RequestDispatcher rq = req.getRequestDispatcher("registerToSession.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionIDString = req.getParameter("session");

        InscritForum user;
        try {
            user = (InscritForum) req.getSession().getAttribute("user");
            Client cli = (Client) personneSrv.getByCompteForum(user);
       
            long sessionID = Long.parseLong(sessionIDString);
            SessionFormation s = srv.getById(sessionID);

            if (s.getParticipants().size() < s.getNbrMaxPlace()) {
                s.getParticipants().add(cli);
                
                srv.refresh(s);
            } else {
            }

        } catch (Exception e) {
        }
    }
}
