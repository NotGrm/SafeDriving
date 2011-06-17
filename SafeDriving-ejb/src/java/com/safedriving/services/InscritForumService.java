/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.InscritForum;
import com.safedriving.model.WebSiteRole;
import java.util.List;
import javax.ejb.EJB;
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

    @EJB
    WebSiteRoleServiceLocal roleSrv;
    
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
        em.merge(inscritForum);
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
        return (InscritForum)q.getSingleResult();
    }

<<<<<<< HEAD
    @Override
    public List<InscritForum> getAllByRole(String roleName) {
        
        WebSiteRole role = roleSrv.getByRoleName(roleName);
        
        Query q = em.createNamedQuery("InscritForum.getAllByRole");
        q.setParameter("role", role);
        return q.getResultList();
    }
    
=======
    public List<InscritForum> getByRole(WebSiteRole role) {
        Query q = em.createNamedQuery("InscritForum.getByRole");
        q.setParameter("role", role);
        return q.getResultList();
    }
>>>>>>> 69749ec0905012af16e51992399f9b27b28a4fae
    
    
    
    
    
}
