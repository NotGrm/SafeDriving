/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface ClientServiceLocal {

    void add(Client client);

    void remove(Client client);

    void refresh(Client client);

    Client getById(int id);

    List<Client> getAll();

    List<Client> getByNom(String name);

    Client getByNumClient(int num);

    List<Client> getBySessionId(int id);
    
}
