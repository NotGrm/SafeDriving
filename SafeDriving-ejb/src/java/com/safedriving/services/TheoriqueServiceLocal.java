/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.model.Theorique;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface TheoriqueServiceLocal {

    void add(Theorique theorique);

    void refresh(Theorique theorique);

    void remove(Theorique theorique);

    List<Theorique> getAll();

    Theorique getById(int id);

    List<Theorique> getByEmpty();

    List<Theorique> getByLieu(Lieu lieu);

    List<Theorique> getByIntervenant(Personnel inter);
    
}
