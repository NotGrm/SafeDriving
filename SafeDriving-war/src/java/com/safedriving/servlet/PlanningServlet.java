/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Client;
import com.safedriving.model.InscritForum;
import com.safedriving.model.ParticipationSession;
import com.safedriving.model.Personne;
import com.safedriving.model.Personnel;
import com.safedriving.model.Pratique;
import com.safedriving.model.SessionFormation;
import com.safedriving.model.Theorique;
import com.safedriving.model.WebSiteRole;
import com.safedriving.services.ClientServiceLocal;
import com.safedriving.services.InscritForumServiceLocal;
import com.safedriving.services.PersonneServiceLocal;
import com.safedriving.services.PersonnelServiceLocal;
import com.safedriving.services.PratiqueServiceLocal;
import com.safedriving.services.SessionFormationServiceLocal;
import com.safedriving.services.TheoriqueServiceLocal;
import com.safedriving.services.WebSiteRoleServiceLocal;
import com.safedriving.services.participationSessionServiceLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ehres
 */
public class PlanningServlet extends HttpServlet {

    @EJB
    TheoriqueServiceLocal srvTheorique;
    @EJB
    PratiqueServiceLocal srvPratique;
    @EJB
    PersonneServiceLocal srvPersonne;
    @EJB
    PersonnelServiceLocal srvPersonnel;
    @EJB
    InscritForumServiceLocal srvCompteWeb;
    @EJB
    ClientServiceLocal srvClient;
    @EJB
    participationSessionServiceLocal srvPart;
    @EJB
    WebSiteRoleServiceLocal srvRole;
    @EJB
    SessionFormationServiceLocal srvSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        int today = cal.get(Calendar.DAY_OF_WEEK);
        int monday = 0, tuesday = 0, wednesday = 0, thursday = 0, friday = 0, saturday = 0, sunday = 0;
        int tabJour[] = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};
        int day = cal.get(Calendar.DATE);
        int iMonth;
        int year = cal.get(Calendar.YEAR);
        String month = new String();
        int calActualMax = 100;
        List<Theorique> theoriques = new ArrayList<Theorique>();
        List<Pratique> pratiques = new ArrayList<Pratique>();
        String listMonth[] = {"Jan", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String strToday = new String();
        InscritForum compte = new InscritForum();
        WebSiteRole role = srvRole.getByRoleName("SERVICE_FORMATION");
        List<InscritForum> comptes = srvCompteWeb.getByRole(role);
        List<Personnel> formateurs = new ArrayList<Personnel>();
        Personne pers = new Personne();
        String message = new String();
        String formateurDemander;

        System.out.println("today : " + today);
        
        try {
            formateurDemander = req.getParameter("formateur");
        } catch (Exception e) {
            formateurDemander = null;
        }

        if (formateurDemander != null) {
            System.out.println("select.id : " + Long.parseLong(req.getParameter("formateur")));
            pers = srvPersonnel.getById(Long.parseLong(req.getParameter("formateur")));
            compte = pers.getCompteForum();
            System.out.println("srvCompteWeb.getById OK : " + compte.getUsername());

        } else {
            compte = (InscritForum) req.getSession().getAttribute("user");
            try {
                pers = srvPersonne.getByCompteForum(compte);
            } catch (Exception e) {
                req.setAttribute("message", message + "Votre Compte n'est pas inscrit definitivement !");
            }
        }


        try {
            for (int i = 0; i < comptes.size(); i++) {
                System.out.println("compte : " + comptes.get(i).getUsername());
                formateurs.add(srvPersonnel.getByCompteForum(comptes.get(i)));
            }
        } catch (Exception e) {
            req.setAttribute("message", message + "Erreur sur liste formateurs");
        }


        try {
            String strNumWeek = req.getParameter("week");
            int numWeek = Integer.parseInt(strNumWeek);
            int resultWeek = numWeek - cal.get(Calendar.WEEK_OF_YEAR);
            int moreDay = resultWeek * Calendar.DAY_OF_WEEK;
            calActualMax = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            cal.add(Calendar.DATE, moreDay);
            day = cal.get(Calendar.DATE);
            year = cal.get(Calendar.YEAR);
            cal2.add(Calendar.WEEK_OF_YEAR, resultWeek);
        } catch (Exception e) {
            System.out.println("Pas de semaine spécial demandé!");
        }

        if (today == Calendar.MONDAY) {
            strToday = "monday";
            monday = day;
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
        } else if (today == Calendar.TUESDAY) {
            strToday = "tuesday";
            tuesday = day;
            monday = tuesday - 1;
            if (monday == 0) {
                monday = calActualMax;
            }
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
        } else if (today == Calendar.WEDNESDAY) {
            strToday = "wednesday";
            wednesday = day;
            monday = wednesday - 2;
            if (monday == 0) {
                monday = calActualMax;
            } else if (monday == -1) {
                monday = calActualMax - 1;
            }
            tuesday = monday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
        } else if (today == Calendar.THURSDAY) {
            strToday = "thurday";
            thursday = day;
            monday = thursday - 3;
            if (monday == 0) {
                monday = calActualMax;
            } else if (monday == -1) {
                monday = calActualMax - 1;
            } else if (monday == -2) {
                monday = calActualMax - 2;
            }
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            friday = thursday + 1;
        } else if (today == Calendar.FRIDAY) {
            strToday = "friday";
            friday = day;
            monday = friday - 4;
            if (monday == 0) {
                monday = calActualMax;
            } else if (monday == -1) {
                monday = calActualMax - 1;
            } else if (monday == -2) {
                monday = calActualMax - 2;
            } else if (monday == -3) {
                monday = calActualMax - 3;
            }
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
        } else if (today == Calendar.SATURDAY) {
            strToday = "saturday";
            saturday = day;
            monday = saturday - 5;
            if (monday == 0) {
                monday = calActualMax;
            } else if (monday == -1) {
                monday = calActualMax - 1;
            } else if (monday == -2) {
                monday = calActualMax - 2;
            } else if (monday == -3) {
                monday = calActualMax - 3;
            } else if (monday == -4) {
                monday = calActualMax - 4;
            }
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.SUNDAY) {
            strToday = "sunday";
            sunday = day;
            monday = sunday - 6;
            if (monday == 0) {
                monday = calActualMax;
            } else if (monday == -1) {
                monday = calActualMax - 1;
            } else if (monday == -2) {
                monday = calActualMax - 2;
            } else if (monday == -3) {
                monday = calActualMax - 3;
            } else if (monday == -4) {
                monday = calActualMax - 4;
            } else if (monday == -5) {
                monday = calActualMax - 5;
            }
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
            saturday = friday + 1;
        }

        if (monday > calActualMax
                || tuesday > calActualMax
                || wednesday > calActualMax
                || thursday > calActualMax
                || friday > calActualMax
                || saturday > calActualMax
                || sunday > calActualMax) {

            if (monday > calActualMax) {
                monday = 1;
            }
            if (tuesday > calActualMax) {
                if (monday == 1) {
                    tuesday = 2;
                } else {
                    tuesday = 1;
                }
            }
            if (wednesday > calActualMax) {
                if (tuesday == 1) {
                    wednesday = 2;
                } else if (tuesday == 2) {
                    wednesday = 3;
                } else {
                    wednesday = 1;
                }
            }
            if (thursday > calActualMax) {
                if (wednesday == 1) {
                    thursday = 2;
                } else if (wednesday == 2) {
                    thursday = 3;
                } else if (wednesday == 3) {
                    thursday = 4;
                } else {
                    thursday = 1;
                }
            }
            if (friday > calActualMax) {
                if (thursday == 1) {
                    friday = 2;
                } else if (thursday == 2) {
                    friday = 3;
                } else if (thursday == 3) {
                    friday = 4;
                } else if (thursday == 4) {
                    friday = 5;
                } else {
                    friday = 1;
                }
            }
            if (saturday > calActualMax) {
                if (friday == 1) {
                    saturday = 2;
                } else if (friday == 2) {
                    saturday = 3;
                } else if (friday == 3) {
                    saturday = 4;
                } else if (friday == 4) {
                    saturday = 5;
                } else if (friday == 5) {
                    saturday = 6;
                } else {
                    saturday = 1;
                }
            }
            if (sunday > calActualMax) {
                if (saturday == 1) {
                    sunday = 2;
                } else if (saturday == 2) {
                    sunday = 3;
                } else if (saturday == 3) {
                    sunday = 4;
                } else if (saturday == 4) {
                    sunday = 5;
                } else if (saturday == 5) {
                    sunday = 6;
                } else if (saturday == 6) {
                    sunday = 7;
                } else {
                    sunday = 1;
                }
            }
        }

        tabJour[0] = monday;
        tabJour[1] = tuesday;
        tabJour[2] = wednesday;
        tabJour[3] = thursday;
        tabJour[4] = friday;
        tabJour[5] = saturday;
        tabJour[6] = sunday;


        iMonth = cal.get(Calendar.MONTH);
        if (iMonth == 0) {
            month = "Janvier";
        } else if (iMonth == 1) {
            month = "Février";
        } else if (iMonth == 2) {
            month = "Mars";
        } else if (iMonth == 3) {
            month = "Avril";
        } else if (iMonth == 4) {
            month = "Mai";
        } else if (iMonth == 5) {
            month = "Juin";
        } else if (iMonth == 6) {
            month = "Juillet";
        } else if (iMonth == 7) {
            month = "Août";
        } else if (iMonth == 8) {
            month = "Septembre";
        } else if (iMonth == 9) {
            month = "Octobre";
        } else if (iMonth == 10) {
            month = "Novembre";
        } else if (iMonth == 11) {
            month = "Décembre";
        }
        //int horaire[] = {89, 910, 1011, 1112, 1314, 1415, 1516, 1617, 1718, 1819};
        int heures[] = {8, 9, 10, 11, 13, 14, 15, 16, 17, 18};
        String jours[] = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        String joursSmall[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        theoriques = srvTheorique.getAll();
        pratiques = srvPratique.getAll();

        if (compte.getRole().equals(srvRole.getByRoleName("CLIENT"))) {
            setAttributeHoraireTheoriqueClient(theoriques, joursSmall, jours, listMonth, tabJour, heures, pers, req);
            setAttributeHorairePratiqueClient(pratiques, joursSmall, jours, listMonth, tabJour, heures, new Client(pers), req);
        } else if (compte.getRole().equals(srvRole.getByRoleName("SERVICE_FORMATION"))) {
            setAttributeHoraireTheoriquePersonnel(theoriques, joursSmall, jours, listMonth, tabJour, heures, pers, req);
            setAttributeHorairePratiquePersonnel(pratiques, joursSmall, jours, listMonth, tabJour, heures, pers, req);
        }

        req.setAttribute("month", month);
        req.setAttribute("year", year);
        req.setAttribute("weekOfYear", cal.get(Calendar.WEEK_OF_YEAR));
        req.setAttribute("currentDay", cal.get(Calendar.DAY_OF_MONTH));
        req.setAttribute("monday", monday);
        req.setAttribute("tuesday", tuesday);
        req.setAttribute("wednesday", wednesday);
        req.setAttribute("thursday", thursday);
        req.setAttribute("friday", friday);
        req.setAttribute("saturday", saturday);
        req.setAttribute("sunday", sunday);
        req.setAttribute("formateurs", formateurs);
        req.setAttribute("currentPersonne", pers);
        req.getRequestDispatcher("planning.jsp").forward(req, resp);
    }

    public void setAttributeHoraireTheoriquePersonnel(List<Theorique> session, String joursSmall[], String jours[], String listMonth[], int tabJour[], int heures[], Personne pers, HttpServletRequest req) {
        try {
            for (int i = 0; i < session.size(); i++) {
                System.out.println("date pratique : " + session.get(i).getDate().toString());
                if (session.get(i).getIntervenant().equals(pers)) {
                    int iDay = Integer.parseInt(session.get(i).getDate().toString().substring(8, 10));
                    String strDay = session.get(i).getDate().toString().substring(0, 3);
                    int heureDebut = session.get(i).getHeureDebut();
                    int duree = session.get(i).getDuree();
                    int heureFin = heureDebut + duree;
                    String dureeSession[] = new String[duree];
                    for (int z = 0; z < duree; z++) {
                        heureFin = heureDebut + 1;
                        dureeSession[z] = heureDebut + "" + heureFin;
                        heureDebut += 1;
                    }
                    for (int r = 0; r < joursSmall.length; r++) {
                        if (strDay.equals(joursSmall[r])) {
                            strDay = jours[r];
                        }
                    }
                    String strMonth = session.get(i).getDate().toString().substring(4, 7);
                    for (int b = 0; b < listMonth.length; b++) {
                        if (strMonth.equals(listMonth[b])) {
                            for (int a = 0; a < tabJour.length; a++) {
                                if (tabJour[a] == iDay) {
                                    for (int t = 0; t < heures.length; t++) {
                                        for (int j = 0; j < jours.length; j++) {
                                            if (strDay.equals(jours[j]) && heures[t] == heureDebut) {
                                                System.out.println("dureeSession.length : " + dureeSession.length);
                                                for (int u = 0; u < dureeSession.length; u++) {
                                                    req.setAttribute(jours[j] + dureeSession[u], session.get(i).getIntervenant().getNom() + " " + session.get(i).getIntervenant().getPrenom() + "</br> Session Théorique");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur getAll");
            System.out.println(e.getMessage());
        }
    }

    public void setAttributeHorairePratiquePersonnel(List<Pratique> session, String joursSmall[], String jours[], String listMonth[], int tabJour[], int heures[], Personne pers, HttpServletRequest req) {
        try {
            for (int i = 0; i < session.size(); i++) {
                System.out.println("date pratique : " + session.get(i).getDate().toString());
                if (session.get(i).getIntervenant().equals(pers)) {
                    int iDay = Integer.parseInt(session.get(i).getDate().toString().substring(8, 10));
                    String strDay = session.get(i).getDate().toString().substring(0, 3);
                    int heureDebut = session.get(i).getHeureDebut();
                    int duree = session.get(i).getDuree();
                    int heureFin = heureDebut + duree;
                    String dureeSession[] = new String[duree];
                    for (int z = 0; z < duree; z++) {
                        heureFin = heureDebut + 1;
                        dureeSession[z] = heureDebut + "" + heureFin;
                        heureDebut += 1;
                    }
                    for (int r = 0; r < joursSmall.length; r++) {
                        if (strDay.equals(joursSmall[r])) {
                            strDay = jours[r];
                        }
                    }
                    String strMonth = session.get(i).getDate().toString().substring(4, 7);
                    for (int b = 0; b < listMonth.length; b++) {
                        if (strMonth.equals(listMonth[b])) {
                            for (int a = 0; a < tabJour.length; a++) {
                                if (tabJour[a] == iDay) {
                                    for (int t = 0; t < heures.length; t++) {
                                        for (int j = 0; j < jours.length; j++) {
                                            if (strDay.equals(jours[j]) && heures[t] == heureDebut) {
                                                System.out.println("dureeSession.length : " + dureeSession.length);
                                                for (int u = 0; u < dureeSession.length; u++) {
                                                    req.setAttribute(jours[j] + dureeSession[u], session.get(i).getIntervenant().getNom() + " " + session.get(i).getIntervenant().getPrenom() + "</br> Session Pratique");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur getAll");
            System.out.println(e.getMessage());
        }
    }

    public void setAttributeHoraireTheoriqueClient(List<Theorique> session, String joursSmall[], String jours[], String listMonth[], int tabJour[], int heures[], Personne pers, HttpServletRequest req) {
        try {
            List<ParticipationSession> part = srvPart.getByClientId(pers.getId());
            for (int i = 0; i < session.size(); i++) {
                System.out.println("date pratique : " + session.get(i).getDate().toString());
                for (int s = 0; s < part.size(); s++) {
                    if (session.get(i).getIntervenant().equals(part.get(s).getSessionFormation().getIntervenant())) {
                        int iDay = Integer.parseInt(session.get(i).getDate().toString().substring(8, 10));
                        String strDay = session.get(i).getDate().toString().substring(0, 3);
                        int heureDebut = session.get(i).getHeureDebut();
                        int duree = session.get(i).getDuree();
                        int heureFin = heureDebut + duree;
                        String dureeSession[] = new String[duree];
                        for (int z = 0; z < duree; z++) {
                            heureFin = heureDebut + 1;
                            dureeSession[z] = heureDebut + "" + heureFin;
                            heureDebut += 1;
                        }
                        for (int r = 0; r < joursSmall.length; r++) {
                            if (strDay.equals(joursSmall[r])) {
                                strDay = jours[r];
                            }
                        }
                        String strMonth = session.get(i).getDate().toString().substring(4, 7);
                        for (int b = 0; b < listMonth.length; b++) {
                            if (strMonth.equals(listMonth[b])) {
                                for (int a = 0; a < tabJour.length; a++) {
                                    if (tabJour[a] == iDay) {
                                        for (int t = 0; t < heures.length; t++) {
                                            for (int j = 0; j < jours.length; j++) {
                                                if (strDay.equals(jours[j]) && heures[t] == heureDebut) {
                                                    System.out.println("dureeSession.length : " + dureeSession.length);
                                                    for (int u = 0; u < dureeSession.length; u++) {
                                                        req.setAttribute(jours[j] + dureeSession[u], session.get(i).getIntervenant().getNom() + " " + session.get(i).getIntervenant().getPrenom() + "</br> Session Théorique");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur getAll");
            System.out.println(e.getMessage());
        }
    }

    public void setAttributeHorairePratiqueClient(List<Pratique> session, String joursSmall[], String jours[], String listMonth[], int tabJour[], int heures[], Client pers, HttpServletRequest req) {
        try {
            List<SessionFormation> sessions = srvSession.findByClient(pers);
            for (int i = 0; i < sessions.size(); i++) {
                System.out.println("date pratique : " + sessions.get(i).getDate().toString());
                //for (int s = 0; s < part.size(); s++) {
                    //if (session.get(i).getIntervenant().equals(part.get(s).getSessionFormation().getIntervenant())) {
                        //int iDay = Integer.parseInt(sessions.get(i).getDate().toString().substring(8, 10));
                        String strDay = sessions.get(i).getDate().toString().substring(0, 3);
                        Calendar cal3 = Calendar.getInstance(Locale.FRENCH);
                        cal3.setTime(sessions.get(i).getDate());
                        int iDay = cal3.get(Calendar.DAY_OF_MONTH);
                        String strMonth = sessions.get(i).getDate().toString().substring(4, 7);
                        
                        int heureDebut = sessions.get(i).getHeureDebut();
                        int duree = sessions.get(i).getDuree();
                        int heureFin = heureDebut + duree;
                        String dureeSession[] = new String[duree];
                        for (int z = 0; z < duree; z++) {
                            heureFin = heureDebut + 1;
                            dureeSession[z] = heureDebut + "" + heureFin;
                            heureDebut += 1;
                        }
                        //Permet de donné le nom entier a une journée
                        for (int r = 0; r < joursSmall.length; r++) {
                            if (strDay.equals(joursSmall[r])) {
                                strDay = jours[r];
                            }
                        }
                        for (int b = 0; b < listMonth.length; b++) {
                            if (strMonth.equals(listMonth[b])) {
                                for (int a = 0; a < tabJour.length; a++) {
                                    if (tabJour[a] == iDay) {
                                        for (int t = 0; t < heures.length; t++) {
                                            for (int j = 0; j < jours.length; j++) {
                                                if (strDay.equals(jours[j]) && heures[t] == heureDebut) {
                                                    System.out.println("dureeSession.length : " + dureeSession.length);
                                                    for (int u = 0; u < dureeSession.length; u++) {
                                                        req.setAttribute(jours[j] + dureeSession[u], sessions.get(i).getIntervenant().getNom() + " " + sessions.get(i).getIntervenant().getPrenom() + "</br> Session Pratique");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    //}
                //}
            }
        } catch (Exception e) {
            System.out.println("Erreur getAll");
            System.out.println(e.getMessage());
        }
    }
}
