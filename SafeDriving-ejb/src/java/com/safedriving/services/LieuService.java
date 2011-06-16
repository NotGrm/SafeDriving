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

    @Override
    public void add(Lieu lieu) {
        em.persist(lieu);
    }

    @Override
    public void remove(Lieu lieu) {
        em.remove(lieu);
    }

    @Override
    public void refresh(Lieu lieu) {
        em.merge(lieu);
    }

    @Override
    public List<Lieu> getAll() {
        Query q = em.createNamedQuery("Lieu.getAll");
        return q.getResultList();
    }

    @Override
    public Lieu getById(int id) {        
        return em.find(Lieu.class, id);
    }

    @Override
    public Lieu getByNom(String nom) {
        Query q = em.createNamedQuery("Lieu.getByNom");
        q.setParameter("name", nom);
        return (Lieu) q.getSingleResult();
    }
    
    
}
