/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.TypeSessionPratique;
import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.model.Pratique;
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
public class PratiqueService implements PratiqueServiceLocal {

    @PersistenceContext
    EntityManager em;
    
    public void add(Pratique pratique) {
        em.persist(pratique);
    }

    public void refresh(Pratique pratique) {
        em.refresh(pratique);
    }

    public void remove(Pratique pratique) {
        em.remove(pratique);
    }

    public List<Pratique> getAll() {
        Query q = em.createNamedQuery("Pratique.getAll");
        return q.getResultList();
    }

    public Pratique getById(int id) {
        Query q = em.createNamedQuery("Pratique.getById");
        q.setParameter("name", id);
        return (Pratique) q.getResultList().get(0);
    }

    public List<Pratique> getByEmpty() {
        Query q = em.createNamedQuery("Pratique.getByEmpty");
        return q.getResultList();
    }

    public List<Pratique> getByLieu(Lieu lieu) {
        Query q = em.createNamedQuery("Pratique.getByLieu");
        q.setParameter("name", lieu);
        return q.getResultList();
    }

    public List<Pratique> getByType(TypeSessionPratique type) {
        Query q = em.createNamedQuery("Pratique.getByType");
        q.setParameter("name", type);
        return q.getResultList();
    }

    public List<Personnel> getByIntervenant(Personnel inter) {
        Query q = em.createNamedQuery("Pratique.getByIntervenant");
        q.setParameter("name", inter);
        return q.getResultList();
    }
    
    
    
}
