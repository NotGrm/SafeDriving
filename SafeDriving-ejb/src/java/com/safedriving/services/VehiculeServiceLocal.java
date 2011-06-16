/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Vehicule;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface VehiculeServiceLocal {

    void add(Vehicule vehicule);

    void refresh(Vehicule vehicule);

    void remove(Vehicule vehicule);

    List<Vehicule> getAll();

    Vehicule getById(int id);

    Vehicule getBySerial(java.lang.String serial);
    
}
