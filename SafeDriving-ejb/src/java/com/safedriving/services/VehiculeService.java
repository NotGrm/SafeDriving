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

    @Override
    public void add(Vehicule vehicule) {
        em.persist(vehicule);
    }

    @Override
    public void refresh(Vehicule vehicule) {
        em.merge(vehicule);
    }

    @Override
    public void remove(Vehicule vehicule) {
        em.remove(vehicule);
    }

    @Override
    public List<Vehicule> getAll() {
        Query q = em.createNamedQuery("Vehicule.getAll");
        return q.getResultList();
    }

    @Override
    public Vehicule getById(long id) {
        return em.find(Vehicule.class, id);
    }
    
    @Override
    public Vehicule getBySerial(String serial) {
        Query q = em.createNamedQuery("Vehicule.getBySerial");
        q.setParameter("serial", serial);
        return (Vehicule)q.getSingleResult();
    }
    
}
