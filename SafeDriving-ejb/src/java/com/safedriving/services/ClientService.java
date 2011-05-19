/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Client;
import com.safedriving.model.SessionFormation;
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

    public void addClient(Client client) {
        em.persist(client);
    }

    public void removeClient(Client client) {
        em.remove(client);
    }

    public void refreshClient(Client client) {
        em.refresh(client);
    }

    public List<Client> getAll() {
        Query q = em.createNamedQuery("Client.getAll");
        return q.getResultList();
    }

    public Client getById(int id) {
        Query q = em.createNamedQuery("Client.getById");
        q.setParameter("name", id);
        return (Client) q.getResultList().get(0);
    }

    public List<Client> getByNom(String name) {
        Query q = em.createNamedQuery("Client.getByName");
        q.setParameter("name", name);
        return q.getResultList();
    }

    public Client getByNumClient(int num) {
        Query q = em.createNamedQuery("Client.getByNumClient");
        q.setParameter("name", num);
        return (Client) q.getResultList().get(0);
    }

    public List<Client> getBySessionId(int id) {
        Query q = em.createNamedQuery("Client.getSession");
        q.setParameter("name", id);
        return q.getResultList();
    }
}
