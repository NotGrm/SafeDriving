/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Examen;
import com.safedriving.model.TypeExamen;
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
public class TypeExamenService implements TypeExamenServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
public void addTypeExamen(TypeExamen examen) {
        em.persist(examen);
    }

    @Override
    public void removeTypeExam(TypeExamen examen) {
        em.remove(examen);
    }

    @Override
    public void refreshTypeExamen(TypeExamen examen) {
        em.refresh(examen);
    }

    @Override
    public List<TypeExamen> getAll() {
        Query q = em.createNamedQuery("TypeExamen.getAll");
        return q.getResultList();
    }

    @Override
    public TypeExamen getById(long id) {
        Query q = em.createNamedQuery("TypeExamen.getById");
        q.setParameter("id", id);
        return (TypeExamen) q.getResultList().get(0);
    }
    
}
