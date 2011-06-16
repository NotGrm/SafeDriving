/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Personnel;
import com.safedriving.model.SessionFormation;
import java.util.Date;
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
public class SessionFormationService implements SessionFormationServiceLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void refresh(SessionFormation session) {
        em.merge(session);
    }
    
    @Override
    public SessionFormation getById(long id) {
        Query q = em.createNamedQuery("SessionFormation.getById");
        q.setParameter("id", id);
        return (SessionFormation)q.getSingleResult();
    }

    @Override
    public List<SessionFormation> findAllByIntervenant(Personnel intervenant) {
        Query q = em.createNamedQuery("SessionFormation.findByIntervenant");
        q.setParameter("intervenant", intervenant);
        return q.getResultList();
    }

    @Override
    public List<SessionFormation> getFutureSession(Date date) {
        Query q = em.createNamedQuery("SessionFormation.findAllAfterDate");
        q.setParameter("date", date);
        return q.getResultList();
    }
}
