/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Client;
import com.safedriving.model.InscritForum;
import com.safedriving.model.ParticipationSession;
import com.safedriving.model.Personnel;
import com.safedriving.model.SessionFormation;
import com.safedriving.services.ClientServiceLocal;
import com.safedriving.services.PersonneServiceLocal;
import com.safedriving.services.SessionFormationServiceLocal;
import com.safedriving.services.participationSessionServiceLocal;
import java.io.IOException;
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
public class AddNoteServlet extends HttpServlet {

    @EJB
    participationSessionServiceLocal srv;
    @EJB
    ClientServiceLocal clientSrv;
    @EJB
    SessionFormationServiceLocal sessionSrv;
    @EJB
    PersonneServiceLocal personneSrv;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InscritForum user;
        try {
            user = (InscritForum) req.getSession().getAttribute("user");

            Personnel pers = (Personnel) personneSrv.getByCompteForum(user);
            List<SessionFormation> Lsession = sessionSrv.findAllByIntervenant(pers);
            
            req.setAttribute("Lsession", Lsession);
        } catch (Exception e) {
            user = null;
        }
        
        RequestDispatcher rq = req.getRequestDispatcher("addNote.jsp");
        rq.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientIDString = req.getParameter("clientID");
        System.out.println(clientIDString);
        String sessionIDString = req.getParameter("sessionID");
        System.out.println(sessionIDString);
        String scoreString = req.getParameter("score");
        System.out.println(scoreString);

        try {
            int score = Integer.parseInt(scoreString);
            long clientID = Long.parseLong(clientIDString);
            long sessionID = Long.parseLong(sessionIDString);

            Client client = clientSrv.getById(clientID);
            SessionFormation session = sessionSrv.getById(sessionID);

            ParticipationSession p = new ParticipationSession();
            p.setClient(client);
            p.setSessionFormation(session);
            p.setScore(score);

            srv.add(p);

        } catch (Exception e) {
        }
        
        resp.sendRedirect("/SafeDriving-war/auth/AddNote");

    }
}
