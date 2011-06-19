/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Disponibility;
import com.safedriving.model.InscritForum;
import com.safedriving.model.Personnel;
import java.util.Date;
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
    
    @Override
    public void add(Disponibility dispo) {
        em.persist(dispo);
    }

    @Override
    public void remove(Disponibility dispo) {
        dispo = em.merge(dispo);
        em.remove(dispo);
    }

    @Override
    public void refresh(Disponibility dispo) {
        em.merge(dispo);
    }

    @Override
    public List<Disponibility> getAll() {
        Query q = em.createNamedQuery("Disponibility.getAll");
        return q.getResultList();
    }

    @Override
    public Disponibility getById(int id) {
        return em.find(Disponibility.class, id);
    }

    @Override
    public Disponibility getByFormateurId(int id) {
        Query q = em.createNamedQuery("Disponibility.getByFormateurId");
        q.setParameter("id", id);
        return (Disponibility)q.getSingleResult();
    }

    @Override
    public Disponibility getForUserAtDate(Personnel user, Date dateDebut, Date dateFin) {
        Query q = em.createNamedQuery("Disponibility.getForUserAtDate");
        q.setParameter("user", user);
        System.out.println("debut "+dateDebut);
        q.setParameter("dateDebut", dateDebut);
        System.out.println("fin "+dateFin);
        q.setParameter("dateFin", dateFin);
        
        try {
            return (Disponibility)q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
    
    
}
