/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.InscritForum;
import com.safedriving.model.Personne;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface PersonneServiceLocal {
    
    void addPersonne(Personne personne);

    Personne getByCompteForum(InscritForum compte);
    
}
