/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.enumeration.Service;
import com.safedriving.model.Personnel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface PersonnelServiceLocal {

    void add(Personnel personnel);

    void refresh(Personnel personnel);

    void remove(Personnel personnel);

    List<Personnel> getAll();

    Personnel getById(int id);

    List<Personnel> getByNom(String nom);

    List<Personnel> getByService(Service service);
    
}
