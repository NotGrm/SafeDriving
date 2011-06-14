/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Personne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ehres
 */
@Stateless
public class PersonneService implements PersonneServiceLocal {

    @PersistenceContext
    private EntityManager em;

    public void addPersonne(Personne personne) {
        em.persist(personne);
    }

    
    
   
}