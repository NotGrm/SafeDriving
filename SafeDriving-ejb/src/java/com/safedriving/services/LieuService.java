/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Lieu;
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
public class LieuService implements LieuServiceLocal {

    @PersistenceContext
    private EntityManager em;

    public void add(Lieu lieu) {
        em.persist(lieu);
    }

    public void remove(Lieu lieu) {
        em.remove(lieu);
    }

    public void refresh(Lieu lieu) {
        em.refresh(lieu);
    }

    public List<Lieu> getAll() {
        Query q = em.createNamedQuery("Lieu.getAll");
        return q.getResultList();
    }

    public Lieu getById(int id) {        
        Query q = em.createNamedQuery("Lieu.getById");
        q.setParameter("name", id);
        return (Lieu) q.getResultList().get(0);
    }

    public Lieu getByNom(String nom) {
        Query q = em.createNamedQuery("Formation.getByNom");
        q.setParameter("name", nom);
        return (Lieu) q.getResultList().get(0);
    }
    
    
}
