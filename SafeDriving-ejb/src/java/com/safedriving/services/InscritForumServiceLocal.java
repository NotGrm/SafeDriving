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

    InscritForum getByUsername(String username);

    InscritForum getByUsernamePwd(String username, String password);

    List<InscritForum> getAllByRole(String roleName);
    
}
