/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.InscritForum;
import com.safedriving.model.Personnel;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
        
    @EJB
    InscritForumServiceLocal compteSrv;

    @Override
    public void add(Personnel personnel) {
        em.persist(personnel);
    }

    @Override
    public void refresh(Personnel personnel) {
        em.merge(personnel);
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
    public List<Personnel> getAllFormateurs() {
        
        List<InscritForum> Lcomptes = compteSrv.getAllByRole("FORMATION");
        
        ArrayList<Personnel> formateurs = new ArrayList<Personnel>();
        
        for (InscritForum inscritForum : Lcomptes) {
            formateurs.add(this.getByCompteForum(inscritForum));
        }
        return formateurs;
    }
    
    @Override
<<<<<<< HEAD
    public Personnel getById(long id) {
=======
    public Personnel getById(Long id) {
>>>>>>> 4f639ee4bb57c04bbe6e7d9d12634a945b961cf5
        return em.find(Personnel.class, id);
    }

    @Override
    public List<Personnel> getByNom(String nom) {
        Query q = em.createNamedQuery("Personnel.getByNom");
        q.setParameter("name", nom);
        return q.getResultList();
    }

    @Override
    public Personnel getByCodePersonnel(String code) {
        Query q = em.createNamedQuery("Personnel.getByCodPers");
        q.setParameter("code", code);
        return (Personnel) q.getSingleResult();
    }

    public Personnel getByCompteForum(InscritForum compte) {
        Query q = em.createNamedQuery("Personnel.getByCompteForum");
        q.setParameter("compte", compte);
        return (Personnel) q.getSingleResult();
    }
    
}
