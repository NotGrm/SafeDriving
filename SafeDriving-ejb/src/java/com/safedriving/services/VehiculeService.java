/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Vehicule;
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
public class VehiculeService implements VehiculeServiceLocal {

    @PersistenceContext
    EntityManager em;

    public void add(Vehicule vehicule) {
        em.persist(vehicule);
    }

    public void refresh(Vehicule vehicule) {
        em.refresh(vehicule);
    }

    public void remove(Vehicule vehicule) {
        em.remove(vehicule);
    }

    public List<Vehicule> getAll() {
        Query q = em.createNamedQuery("Vehicule.getAll");
        return q.getResultList();
    }

    public Vehicule getById(int id) {
        Query q = em.createNamedQuery("Vehicule.getById");
        q.setParameter("name", id);
        return (Vehicule)q.getResultList().get(0);
    }
    
    
    
}
