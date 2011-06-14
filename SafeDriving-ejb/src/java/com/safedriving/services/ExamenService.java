/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Examen;
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
public class ExamenService implements ExamenServiceLocal {
    
    @PersistenceContext
    private EntityManager em;

    public void add(Examen examen) {
        em.persist(examen);
    }

    public void remove(Examen examen) {
        em.remove(examen);
    }

    public void refresh(Examen examen) {
        em.merge(examen);
    }

    public List<Examen> getAll() {
        Query q = em.createNamedQuery("Examen.getAll");
        return q.getResultList();
    }

    public Examen getById(int id) {
        return em.find(Examen.class, id);
    }

    public Examen getEmpty(Examen examen) {
        Query q = em.createNamedQuery("Examen.getEmpty");
        q.setParameter("name", examen);
        return (Examen) q.getResultList().get(0);
    }

    public List<Examen> getByType(String type) {
        Query q = em.createNamedQuery("Examen.getByType");
        q.setParameter("name", type);
        return q.getResultList();
    }

    public List<Examen> getByLieu(String lieu) {
        Query q = em.createNamedQuery("Examen.getByLieu");
        q.setParameter("name", lieu);
        return q.getResultList();
    }

    public List<Examen> getByIntervenant(Personnel intervenant) {
        Query q = em.createNamedQuery("Examen.getByIntervenant");
        q.setParameter("name", intervenant);
        return q.getResultList();
    }
    
   
    
}
