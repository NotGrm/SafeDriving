/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.enumeration.Service;
import com.safedriving.model.Personnel;
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
public class PersonnelService implements PersonnelServiceLocal {

    @PersistenceContext
    EntityManager em;
    
    public void add(Personnel personnel) {
        em.persist(personnel);
    }

    public void refresh(Personnel personnel) {
        em.refresh(personnel);
    }

    public void remove(Personnel personnel) {
        em.remove(personnel);
    }

    public List<Personnel> getAll() {
        Query q = em.createNamedQuery("Personnel.getAll");
        return q.getResultList();
    }

    public Personnel getById(int id) {
        Query q = em.createNamedQuery("Personnel.getById");
        q.setParameter("name", id);
        return (Personnel) q.getResultList().get(0);
    }

    public List<Personnel> getByNom(String nom) {
        Query q = em.createNamedQuery("Personnel.getByNom");
        q.setParameter("name", nom);
        return q.getResultList();
    }

    public List<Personnel> getByService(Service service) {
        Query q = em.createNamedQuery("Personnel.getByService");
        q.setParameter("name", service);
        return q.getResultList();
    }
    
    
    
    
    
    

    
    
}
