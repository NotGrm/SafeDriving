/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.blog.Categorie;
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
public class CategorieService implements CategorieServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCategorie(Categorie categorie) {
        em.persist(categorie);
    }

    @Override
    public void removeCategorie(Categorie categorie) {
        em.remove(categorie);
    }

    @Override
    public void modifierCategorie(Categorie categorie) {
        //em.refresh(categorie);
        em.merge(categorie);
    }

    @Override
    public Categorie getById(Long id) {
        return em.find(Categorie.class, id);
    }
    
    @Override
    public List<Categorie> getAllCategorie() {
        Query q = em.createNamedQuery("Categorie.getAll");
        return (List<Categorie>) q.getResultList();
    }
    
    @Override
    public List<Categorie> getAllTopLevelCategorie() {
        Query q = em.createNamedQuery("Categorie.getAllFirstLevel");
        return (List<Categorie>) q.getResultList();
    }
    
}
