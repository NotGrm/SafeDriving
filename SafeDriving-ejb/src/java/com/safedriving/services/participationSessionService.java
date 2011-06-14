/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.ParticipationSession;
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
public class participationSessionService implements participationSessionServiceLocal {

    @PersistenceContext
    private EntityManager em;
    
    public void add(ParticipationSession partSession) {
        em.persist(partSession);
    }

    public void remove(ParticipationSession partSession) {
        em.remove(partSession);
    }

    public void refresh(ParticipationSession partSession) {
        em.merge(partSession);
    }

    public List<ParticipationSession> getByClientId(long id) {
        Query q = em.createNamedQuery("ParticipationSession.getbyClient");
        q.setParameter("id", id);
        return q.getResultList();
    }

    
    
}
