/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.InscritForum;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface InscritForumServiceLocal {

    void addInscriptForum(InscritForum inscritForum);
    
}
