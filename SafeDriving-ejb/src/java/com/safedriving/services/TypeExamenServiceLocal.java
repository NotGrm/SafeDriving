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
public interface TypeExamenServiceLocal {

    public void add(com.safedriving.model.TypeExamen examen);

    public void remove(com.safedriving.model.TypeExamen examen);

    public void refresh(com.safedriving.model.TypeExamen examen);

    public java.util.List<com.safedriving.model.TypeExamen> getAll();

    public com.safedriving.model.TypeExamen getById(long id);

    
    
}
