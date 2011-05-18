/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Personnel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ehres
 */
@Stateless
public class PersonnelService implements PersonnelServiceLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    
    public void addPersonnel(Personnel personnel) {
        em.persist(personnel);
    }

    public void removePersonnel(Personnel personnel) {
        em.remove(personnel);
    }

    public void modifiePersonnel(Personnel personnel) {
        em.refresh(personnel);
    }
}
