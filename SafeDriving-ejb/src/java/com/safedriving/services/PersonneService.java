/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.InscritForum;
import com.safedriving.model.Personne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ehres
 */
@Stateless
public class PersonneService implements PersonneServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addPersonne(Personne personne) {
        em.persist(personne);
    }

    @Override
    public Personne getByCompteForum(InscritForum compte) {
        Query q = em.createNamedQuery("Personne.getByCompteForum");
        q.setParameter("compte", compte);
        
        return (Personne) q.getSingleResult();
    }
   
}