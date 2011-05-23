/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Departement;
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
    
    @Override
    public void add(Personnel personnel) {
        em.persist(personnel);
    }

    @Override
    public void refresh(Personnel personnel) {
        em.refresh(personnel);
    }

    @Override
    public void remove(Personnel personnel) {
        em.remove(personnel);
    }

    @Override
    public List<Personnel> getAll() {
        Query q = em.createNamedQuery("Personnel.getAll");
        return q.getResultList();
    }

    @Override
    public Personnel getById(int id) {
        Query q = em.createNamedQuery("Personnel.getById");
        q.setParameter("name", id);
        return (Personnel) q.getResultList().get(0);
    }

    @Override
    public List<Personnel> getByNom(String nom) {
        Query q = em.createNamedQuery("Personnel.getByNom");
        q.setParameter("name", nom);
        return q.getResultList();
    }

    @Override
    public List<Personnel> getByService(Departement service) {
        Query q = em.createNamedQuery("Personnel.getByService");
        q.setParameter("name", service);
        return q.getResultList();
    }
    
    @Override
    public Personnel getByCodePersonnel(String code)
    {
        Query q = em.createNamedQuery("Personnel.GetByCodPers");
        q.setParameter("code", code);
        return (Personnel)q.getSingleResult();
    }
    
    
    
    
    
    

    
    
}
