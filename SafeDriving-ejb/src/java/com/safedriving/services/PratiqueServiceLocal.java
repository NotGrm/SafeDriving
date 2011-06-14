/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.TypeSessionPratique;
import com.safedriving.model.Lieu;
import com.safedriving.model.Personnel;
import com.safedriving.model.Pratique;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface PratiqueServiceLocal {

    void add(Pratique pratique);

    void refresh(Pratique pratique);

    void remove(Pratique pratique);

    List<Pratique> getAll();

    Pratique getById(int id);

    List<Pratique> getByEmpty();

    List<Pratique> getByLieu(Lieu lieu);

    List<Pratique> getByType(TypeSessionPratique type);

    List<Personnel> getByIntervenant(Personnel inter);
    
}
