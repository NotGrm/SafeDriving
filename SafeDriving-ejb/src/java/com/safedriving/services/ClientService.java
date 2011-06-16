/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Client;
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
public class ClientService implements ClientServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Client client) {
        em.persist(client);
    }

    @Override
    public void remove(Client client) {
        em.remove(client);
    }

    @Override
    public void refresh(Client client) {
        em.merge(client);
    }

    @Override
    public List<Client> getAll() {
        Query q = em.createNamedQuery("Client.getAll");
        return q.getResultList();
    }

    @Override
    public Client getById(long id) {
        Query q = em.createNamedQuery("Client.getById");
        q.setParameter("id", id);
        return (Client)q.getSingleResult();
    }

    @Override
    public List<Client> getByNom(String name) {
        Query q = em.createNamedQuery("Client.getByName");
        q.setParameter("name", name);
        return q.getResultList();
    }

    @Override
    public Client getByNumClient(int num) {
        Query q = em.createNamedQuery("Client.getByNumClient");
        q.setParameter("num", num);
        return (Client) q.getResultList().get(0);
    }

    @Override
    public List<Client> getBySessionId(int id) {
        Query q = em.createNamedQuery("Client.getSession");
        q.setParameter("name", id);
        return q.getResultList();
    }
}
