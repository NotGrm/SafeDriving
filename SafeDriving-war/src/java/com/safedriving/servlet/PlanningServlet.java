/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import com.safedriving.model.Pratique;
import com.safedriving.model.Theorique;
import com.safedriving.services.PratiqueServiceLocal;
import com.safedriving.services.TheoriqueServiceLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE));
        int today = cal.get(Calendar.DAY_OF_WEEK);
        int monday = 0, tuesday = 0, wednesday = 0, thursday = 0, friday = 0, saturday = 0, sunday = 0;
        int tabJour[] = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};
        int day = cal.get(Calendar.DATE);
        int iMonth;
        int year = cal.get(Calendar.YEAR);
        String month = new String();
        int calActualMax = 100;
        List<Theorique> theoriques;
        List<Pratique> pratiques;
        String listMonth[] = {"Jan", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String strToday = new String();

        try {
            String strNumWeek = req.getParameter("week");
            int numWeek = Integer.parseInt(strNumWeek);
            int resultWeek = numWeek - cal.get(Calendar.WEEK_OF_YEAR);
            int moreDay = resultWeek * Calendar.DAY_OF_WEEK;
            int moisPrecedant = cal.get(Calendar.MONTH);
            cal.add(Calendar.DATE, moreDay);
            calActualMax = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            day = cal.get(Calendar.DATE);
            year = cal.get(Calendar.YEAR);
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
            saturday = friday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.TUESDAY) {
            strToday = "tuesday";
            tuesday = day;
            monday = tuesday - 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
            saturday = friday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.WEDNESDAY) {
            strToday = "wednesday";
            wednesday = day;
            monday = wednesday - 2;
            tuesday = monday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
            saturday = friday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.THURSDAY) {
            strToday = "thurday";
            thursday = day;
            monday = thursday - 3;
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            friday = thursday + 1;
            saturday = friday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.FRIDAY) {
            strToday = "friday";
            friday = day;
            monday = friday - 4;
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            saturday = friday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.SATURDAY) {
            strToday = "saturday";
            saturday = day;
            monday = saturday - 5;
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.SUNDAY) {
            strToday = "sunday";
            sunday = day;
            monday = sunday - 6;
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
        System.out.println("taillejour : " + jours.length);

        try {
            theoriques = srvTheorique.getAll();
            System.out.println("taille : " + theoriques.size());
            //pratiques = srvPratique.getAll();
            for (int i = 0; i < theoriques.size(); i++) {
                System.out.println("date pratique : " + theoriques.get(i).getDate().toString());
                int iDay = Integer.parseInt(theoriques.get(i).getDate().toString().substring(8, 10));
                String strDay = theoriques.get(i).getDate().toString().substring(0, 3);
                int heureDebut = theoriques.get(i).getHeureDebut();
                int duree = theoriques.get(i).getDuree();
                int heureFin = heureDebut + duree;
                String dureeSession [] = new String [duree];
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
                String strMonth = theoriques.get(i).getDate().toString().substring(4, 7);
                for (int b = 0; b < listMonth.length; b++) {
                    if (strMonth.equals(listMonth[b])) {
                        for (int a = 0; a < tabJour.length; a++) {
                            if (tabJour[a] == iDay) {
                                for (int t = 0; t < heures.length; t++) {
                                    for (int j = 0; j < jours.length; j++) {
                                        if (strDay.equals(jours[j]) && heures[t] == heureDebut) {
                                            System.out.println("dureeSession.length : " + dureeSession.length);
                                            for (int u = 0; u < dureeSession.length; u++) {
                                                req.setAttribute(jours[j] + dureeSession[u], theoriques.get(i).getIntervenant().getNom() + " " + theoriques.get(i).getIntervenant().getPrenom());
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
        req.getRequestDispatcher("planning.jsp").forward(req, resp);
    }
}
