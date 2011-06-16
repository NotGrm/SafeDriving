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
    public void add(WebSiteRole role) {
        em.persist(role);
    }

    @Override
    public void remove(WebSiteRole role) {
        em.remove(role);
    }

    @Override
    public void refresh(WebSiteRole role) {
        em.merge(role);
    }

    @Override
    public List<WebSiteRole> getAll() {
        Query q = em.createNamedQuery("WebSiteRole.getAll");
        return q.getResultList();
    }

    @Override
    public WebSiteRole getById(long id) {
        return em.find(WebSiteRole.class, id);
    }
}
