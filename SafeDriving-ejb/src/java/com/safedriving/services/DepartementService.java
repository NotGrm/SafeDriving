/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Departement;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Grm
 */
@Stateless
public class DepartementService implements DepartementServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
public void addDepartement(Departement examen) {
        em.persist(examen);
    }

    @Override
    public void removeDepartement(Departement examen) {
        em.remove(examen);
    }

    @Override
    public void refreshDepartement(Departement examen) {
        em.refresh(examen);
    }

    @Override
    public List<Departement> getAll() {
        Query q = em.createNamedQuery("Departement.getAll");
        return q.getResultList();
    }

    @Override
    public Departement getById(long id) {
        Query q = em.createNamedQuery("Departement.getById");
        q.setParameter("id", id);
        return (Departement) q.getResultList().get(0);
    }
    
}
