/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import javax.ejb.Local;

/**
 *
 * @author Grm
 */
@Local
public interface CategorieServiceLocal {

    public void addCategorie(com.safedriving.model.blog.Categorie categorie);

    public void removeCategorie(com.safedriving.model.blog.Categorie categorie);

    public void modifierCategorie(com.safedriving.model.blog.Categorie categorie);

    public java.util.List<com.safedriving.model.blog.Categorie> getAllCategorie();

    public java.util.List<com.safedriving.model.blog.Categorie> getAllTopLevelCategorie();

    public com.safedriving.model.blog.Categorie getById(Long id);
    
}
