/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Client;
import com.safedriving.model.Formation;
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
public class FormationService implements FormationServiceLocal {

    @PersistenceContext
    private EntityManager em;

    public void add(Formation formation) {
        em.persist(formation);
    }

    public void remove(Formation formation) {
        em.remove(formation);
    }

    public void refresh(Formation formation) {
        em.refresh(formation);
    }

    public List<Formation> getAll() {
        Query q = em.createNamedQuery("Formation.getAll");
        return q.getResultList();
    }

    public Formation getById(int id) {
        Query q = em.createNamedQuery("Formation.getById");
        q.setParameter("name", id);
        return (Formation) q.getResultList().get(0);
    }

    public List<Formation> getByClientId(int id) {
        Query q = em.createNamedQuery("Formation.getByClient");
        q.setParameter("name", id);
        return q.getResultList();
    }

    public List<Formation> getByCodeObtenu(boolean codeObtenu) {        
        Query q = em.createNamedQuery("Formation.getByCodeObtenu");
        q.setParameter("name", codeObtenu);
        return q.getResultList();
    }
    
    
}
