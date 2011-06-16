/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Disponibility;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface DisponibilityServiceLocal {

    void add(Disponibility dispo);

    void remove(Disponibility dispo);

    void refresh(Disponibility dispo);

    List<Disponibility> getAll();

    Disponibility getById(int id);

    Disponibility getByFormateurId(int id);
    
}