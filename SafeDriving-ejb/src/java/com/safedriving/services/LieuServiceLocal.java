/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Lieu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface LieuServiceLocal {

    void add(Lieu lieu);

    void remove(Lieu lieu);

    void refresh(Lieu lieu);

    List<Lieu> getAll();

    Lieu getById(int id);

    Lieu getByNom(String nom);
    
}
