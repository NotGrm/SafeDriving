/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.TypeSessionPratique;
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
public class TypeSessionPratiqueService implements TypeSessionPratiqueServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(TypeSessionPratique type) {
        em.persist(type);
    }

    @Override
    public void refresh(TypeSessionPratique type) {
        em.merge(type);
    }

    @Override
    public void remove(TypeSessionPratique type) {
        em.remove(type);
    }

    @Override
    public List<TypeSessionPratique> getAll() {
        Query q = em.createNamedQuery("TypeSessionPratique.getAll");
        return q.getResultList();
    }

    @Override
    public TypeSessionPratique getById(long id) {
        return em.find(TypeSessionPratique.class, id);
    }

    @Override
    public TypeSessionPratique getByTypeName(String name) {
        Query q = em.createNamedQuery("TypeSessionPratique.getByTypeName");
        q.setParameter("typeName", name);
        return (TypeSessionPratique) q.getSingleResult();
    }
}
