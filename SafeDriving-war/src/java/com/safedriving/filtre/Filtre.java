/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.filtre;

import com.safedriving.model.InscritForum;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ehres
 */
public class Filtre implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        InscritForum user = (InscritForum) httpRequest.getSession().getAttribute("user");
        request.setAttribute("path", httpRequest.getRequestURI());

        if (user != null) {
            String roleName = user.getRole().getRoleName();
            String nameFonction = httpRequest.getRequestURI().substring(22);
            System.out.println("Fonction demandé" + nameFonction);
            boolean access = false;
            if (nameFonction.equals("AddArticle")) {
                if (roleName.equals("DIRECTION") || roleName.equals("REDACTION")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddClient")) {
                if (roleName.equals("DIRECTION") || roleName.equals("SERVICE_FORMATION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddExamen")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddLieu")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddPersonnel")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddService")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            } else if (nameFonction.equals("ShowClients")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            } else if (nameFonction.equals("ShowEmployes")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            } else if (nameFonction.equals("ClientDetail")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            }else if (nameFonction.equals("EmployeDetail")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddSessionPratique")) {
                if (roleName.equals("DIRECTION") || roleName.equals("SERVICE_FORMATION")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddSessionTheorique")) {
                if (roleName.equals("DIRECTION") || roleName.equals("SERVICE_FORMATION")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddTypeExamen")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE") || roleName.equals("SERVICE_FORMATION")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddTypePratique")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE") || roleName.equals("SERVICE_FORMATION")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddVehicule")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            } else if (nameFonction.equals("AddCompteWeb")) {
                if (roleName.equals("DIRECTION") || roleName.equals("GESTION_AGENCE")) {
                    access = true;
                }
            } else if (nameFonction.equals("Planning")) {
                access = true;
            }

            if (access == true) {
                chain.doFilter(request, response);
            } else {
                RequestDispatcher rq = request.getRequestDispatcher("accessDenied.jsp");
                rq.forward(request, response);
            }

        } else {
            httpResponse.sendRedirect("/SafeDriving-war/Login?path=" + httpRequest.getRequestURI());
        }


    }

    @Override
    public void destroy() {
    }
}
