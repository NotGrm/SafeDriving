/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.InscritForum;
import com.safedriving.model.WebSiteRole;
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

<<<<<<< HEAD
    List<InscritForum> getAllByRole(String roleName);
=======
    List<InscritForum> getByRole(WebSiteRole role);
>>>>>>> 69749ec0905012af16e51992399f9b27b28a4fae
    
}
