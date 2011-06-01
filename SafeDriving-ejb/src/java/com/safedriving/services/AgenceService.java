/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Agence;
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
public class AgenceService implements AgenceServiceLocal {

    @PersistenceContext
    private EntityManager em;
    
    public void add(Agence agence) {
        em.persist(agence);
    }

    public void refresh(Agence agence) {
        em.refresh(agence);
    }

    public void remove(Agence agence) {
        em.remove(agence);
    }

    public List<Agence> getAll() {
        Query q = em.createNamedQuery("Agence.getAll");
        return (List<Agence>) q.getResultList();
    }
    
    public Agence getById(int id) {
        Query q = em.createNamedQuery("Agence.getById");
        q.setParameter("id", id);
        return (Agence)q.getSingleResult();
    }

    public List<Agence> getByNom(String nom) {
        Query q = em.createNamedQuery("Agence.getByNom");
        q.setParameter("name", nom);
        return (List<Agence>) q.getResultList();
    }

    
    
    
    
}
