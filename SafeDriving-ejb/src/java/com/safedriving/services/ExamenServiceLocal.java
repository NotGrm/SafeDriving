/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Examen;
import com.safedriving.model.Personnel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface ExamenServiceLocal {

    void add(Examen examen);

    void remove(Examen examen);

    void refresh(Examen examen);

    List<Examen> getAll();

    Examen getById(int id);

    Examen getEmpty(Examen examen);

    List<Examen> getByType(String type);

    List<Examen> getByLieu(String lieu);

    List<Examen> getByIntervenant(Personnel intervenant);
    
}
