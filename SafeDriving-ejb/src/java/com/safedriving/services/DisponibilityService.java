/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Disponibility;
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
public class DisponibilityService implements DisponibilityServiceLocal {

    @PersistenceContext
    private EntityManager em;
    
    public void add(Disponibility dispo) {
        em.persist(dispo);
    }

    public void remove(Disponibility dispo) {
        em.remove(dispo);
    }

    public void refresh(Disponibility dispo) {
        em.merge(dispo);
    }

    public List<Disponibility> getAll() {
        Query q = em.createNamedQuery("Disponibility.getAll");
        return q.getResultList();
    }

    public Disponibility getById(int id) {
        return em.find(Disponibility.class, id);
    }

    public Disponibility getByFormateurId(int id) {
        Query q = em.createNamedQuery("Disponibility.getByFormateurId");
        q.setParameter("id", id);
        return (Disponibility)q.getSingleResult();
    }
    
    
    
    
}
