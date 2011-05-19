/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.InscritForum;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface InscritForumServiceLocal {

    void add(InscritForum inscritForum);

    void remove(InscritForum inscritForum);

    void refresh(InscritForum inscritForum);

    InscritForum getById(int id);

    List<InscritForum>  getByNom(String nom);

    InscritForum getByUserName(String username);
    
}
