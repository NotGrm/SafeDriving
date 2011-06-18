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
    
    @Override
    public void add(WebSiteRole webSiteRole) {
        em.persist(webSiteRole);
    }

    @Override
    public void remove(WebSiteRole webSiteRole) {
        em.remove(webSiteRole);
    }

    @Override
    public void refresh(WebSiteRole webSiteRole) {
        em.merge(webSiteRole);
    }

    @Override
    public List<WebSiteRole> getAll() {
        Query q = em.createNamedQuery("WebSiteRole.getAll");
        return (List<WebSiteRole>) q.getResultList();
    }

    @Override
    public WebSiteRole getById(Long id) {        
        return em.find(WebSiteRole.class, id);
    }

    @Override
    public WebSiteRole getByRoleName(String roleName) {
        Query q = em.createNamedQuery("WebSiteRole.getByRoleName");
        q.setParameter("roleName", roleName);
        return (WebSiteRole) q.getSingleResult();
    }

    
    
}
