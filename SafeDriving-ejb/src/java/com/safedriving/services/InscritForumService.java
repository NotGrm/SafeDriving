/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.InscritForum;
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
public class InscritForumService implements InscritForumServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(InscritForum inscritForum) {
        em.persist(inscritForum);
    }

    @Override
    public void remove(InscritForum inscritForum) {
        em.remove(inscritForum);
    }

    @Override
    public void refresh(InscritForum inscritForum) {
        em.refresh(inscritForum);
    }

    @Override
    public InscritForum getById(int id) {
        Query q = em.createNamedQuery("InscritForum.getById");
        q.setParameter("name", id);
        return (InscritForum) q.getResultList().get(0);
    }

    @Override
    public InscritForum getByUserName(String username) {
        Query q = em.createNamedQuery("InscritForum.getByUserName");
        q.setParameter("username", username);
        return (InscritForum)q.getSingleResult();
    }
    
    
    
}
