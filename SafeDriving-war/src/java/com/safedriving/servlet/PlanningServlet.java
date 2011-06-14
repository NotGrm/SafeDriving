/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.servlet;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ehres
 */
public class PlanningServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE));
        int today = cal.get(Calendar.DAY_OF_WEEK);
        int monday = 0, tuesday = 0, wednesday = 0, thursday = 0, friday = 0, saturday = 0, sunday = 0;
        int day = cal.get(Calendar.DATE);
        int iMonth;
        int year = cal.get(Calendar.YEAR);
        String month = new String();
        int calActualMax = 100;
        
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
            monday = day;
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
            saturday = friday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.TUESDAY) {
            tuesday = day;
            monday = tuesday - 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
            saturday = friday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.WEDNESDAY) {
            wednesday = day;
            monday = wednesday - 2;
            tuesday = monday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
            saturday = friday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.THURSDAY) {
            thursday = day;
            monday = thursday - 3;
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            friday = thursday + 1;
            saturday = friday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.FRIDAY) {
            friday = day;
            monday = friday - 4;
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            saturday = friday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.SATURDAY) {
            saturday = day;
            monday = saturday - 5;
            tuesday = monday + 1;
            wednesday = tuesday + 1;
            thursday = wednesday + 1;
            friday = thursday + 1;
            sunday = saturday + 1;
        } else if (today == Calendar.SUNDAY) {
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

        System.out.println("date : " + day);
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
