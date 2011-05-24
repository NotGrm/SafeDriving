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
public interface DepartementServiceLocal {

    public com.safedriving.model.Departement getById(long id);

    public java.util.List<com.safedriving.model.Departement> getAll();

    public void refreshDepartement(com.safedriving.model.Departement examen);

    public void removeDepartement(com.safedriving.model.Departement examen);

    public void addDepartement(com.safedriving.model.Departement examen);
    
}
