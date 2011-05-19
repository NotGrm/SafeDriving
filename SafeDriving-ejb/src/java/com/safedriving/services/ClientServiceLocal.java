/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Client;
import com.safedriving.model.SessionFormation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface ClientServiceLocal {

    void addClient(Client client);

    void removeClient(Client client);

    void refreshClient(Client client);

    Client getById(int id);

    List<Client> getAll();

    List<Client> getByNom(String name);

    Client getByNumClient(int num);

    List<Client> getBySessionId(int id);
    
}
