/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.blog.Tag;
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
public class TagService implements TagServiceLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void add(Tag tag) {
        em.persist(tag);
    }

    @Override
    public List<Tag> getAllTag() {
        Query q = em.createNamedQuery("Tag.getAll");
        return (List<Tag>)q.getResultList();
    }
    
    
}
