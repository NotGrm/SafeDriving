/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.filtre;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ehres
 */
public class Filtre implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if (httpRequest.getSession().getAttribute("username") != null) {
            chain.doFilter(request, response);
        } else {
            System.out.println("redirection login, path : " + httpRequest.getRequestURI());
            request.setAttribute("path", httpRequest.getRequestURI());
            
            httpResponse.sendRedirect("/SafeDriving-war/Login?path=" + httpRequest.getRequestURI());
        }
    }

    @Override
    public void destroy() {
    }
    
}
