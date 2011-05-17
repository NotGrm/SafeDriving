/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.InscritForum;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ehres
 */
@Stateless
public class InscritForumService implements InscritForumServiceLocal {

    @PersistenceContext
    private EntityManager em;

    public void addInscriptForum(InscritForum inscritForum) {
        em.persist(inscritForum);
    }
    
    
    
}
