/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.InscritForum;
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

    Personnel getById(long id);

    List<Personnel> getByNom(String nom);

    public com.safedriving.model.Personnel getByCodePersonnel(java.lang.String code);

    Personnel getByCompteForum(InscritForum compte);

    List<Personnel> getAllFormateurs();
    
}
