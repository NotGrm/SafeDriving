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
        return em.find(InscritForum.class, id);
    }

    @Override
    public InscritForum getByUsername(String username) {
        Query q = em.createNamedQuery("InscritForum.getByUsername");
        q.setParameter("username", username);
        return (InscritForum)q.getSingleResult();
    }

    @Override
    public InscritForum getByUsernamePwd(String username, String password) {        
        Query q = em.createNamedQuery("InscritForum.getByUsernamePwd");
        q.setParameter("username", username);
        q.setParameter("password", password);
        //return (InscritForum)q.getSingleResult();
        return (InscritForum)q.getResultList().get(0);
    }
    
    
    
    
    
}
