/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.model.Theorique;
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
public class TheoriqueService implements TheoriqueServiceLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public void add(Theorique theorique) {
        em.persist(theorique);
    }

    @Override
    public void refresh(Theorique theorique) {
        em.merge(theorique);              
    }

    @Override
    public void remove(Theorique theorique) {
        em.remove(theorique);
    }

    @Override
    public List<Theorique> getAll() {
        Query q = em.createNamedQuery("Theorique.getAll");
        return q.getResultList();
    }

    @Override
    public Theorique getById(int id) {
        return em.find(Theorique.class, id);
    }

    @Override
    public List<Theorique> getByEmpty() {
        Query q = em.createNamedQuery("Theorique.getByEmpty");
        return q.getResultList();
    }

    @Override
    public List<Theorique> getByLieu(Lieu lieu) {
        Query q = em.createNamedQuery("Theorique.getByLieu");
        q.setParameter("lieu", lieu);
        return q.getResultList();
    }

    @Override
    public List<Theorique> getByIntervenant(Personnel inter) {
        Query q = em.createNamedQuery("Theorique.getByIntervenant");
        q.setParameter("inter", inter);
        return q.getResultList();
    }
        
    
    
}
