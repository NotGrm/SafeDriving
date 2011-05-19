/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Formation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface FormationServiceLocal {

    List<Formation> getAll();

    Formation getById(int id);

    void add(Formation formation);

    void remove(Formation formation);

    void refresh(Formation formation);

    List<Formation> getByClientId(int id);

    List<Formation> getByCodeObtenu(boolean codeObtenu);
    
}
