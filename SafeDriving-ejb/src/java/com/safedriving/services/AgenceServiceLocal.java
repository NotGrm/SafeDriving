/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Agence;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface AgenceServiceLocal {

    void add(Agence agence);

    void refresh(Agence agence);

    void remove(Agence agence);

    List<Agence> getAll();

    List<Agence> getByNom(String nom);
    
    Agence getById(int id);
    
}
