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
 * @author Grm
 */
@Stateless
public class RoleService implements RoleServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addWebSiteRole(WebSiteRole role) {
        em.persist(role);
    }

    @Override
    public void removeWebSiteRole(WebSiteRole role) {
        em.remove(role);
    }

    @Override
    public void refreshWebSiteRole(WebSiteRole role) {
        em.merge(role);
    }

    @Override
    public List<WebSiteRole> getAll() {
        Query q = em.createNamedQuery("WebSiteRole.getAll");
        return q.getResultList();
    }

    @Override
    public WebSiteRole getById(long id) {
        Query q = em.createNamedQuery("WebSiteRole.getById");
        q.setParameter("id", id);
        return (WebSiteRole) q.getResultList().get(0);
    }
}
