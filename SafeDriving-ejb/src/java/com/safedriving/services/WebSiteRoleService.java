/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.WebSiteRole;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ehres
 */
@Stateless
public class WebSiteRoleService implements WebSiteRoleServiceLocal {

    @PersistenceContext
    private EntityManager em;
    
    public void add(WebSiteRole webSiteRole) {
        em.persist(webSiteRole);
    }

    public void remove(WebSiteRole webSiteRole) {
        em.remove(webSiteRole);
    }

    public void refresh(WebSiteRole webSiteRole) {
        em.merge(webSiteRole);
    }

    public List<WebSiteRole> getAll() {
        Query q = em.createNamedQuery("WebSiteRole.getAll");
        return (List<WebSiteRole>) q.getResultList();
    }

    public WebSiteRole getById(int id) {        
        return em.find(WebSiteRole.class, id);
    }

    public WebSiteRole getByRoleName(String roleName) {
        Query q = em.createNamedQuery("WebSiteRole.getByRoleName");
        q.setParameter("roleName", roleName);
        return (WebSiteRole) q.getSingleResult();
    }

    
    
}
