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
    public void add(TypeSessionPratique type)
    {
        em.persist(type);
    }

    @Override
    public void refresh(TypeSessionPratique type)
    {
        em.refresh(type);
    }

    @Override
    public void remove(TypeSessionPratique type)
    {
        em.remove(type);
    }

    @Override
    public List<TypeSessionPratique> getAll() {
        Query q = em.createNamedQuery("TypeSessionPratique.getAll");
        return q.getResultList();
    }

    @Override
    public TypeSessionPratique getById(long id) {
        Query q = em.createNamedQuery("TypeSessionPratique.getById");
        q.setParameter("id", id);
        return (TypeSessionPratique) q.getSingleResult();
    }
    
    @Override
    public TypeSessionPratique getByName(String name)
    {
        Query q = em.createNamedQuery("TypeSessionPratique.getByName");
        q.setParameter("name", name);
        return (TypeSessionPratique) q.getSingleResult();
    }
    
}
