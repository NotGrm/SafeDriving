/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Ehres
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "TypeSessionPratique.getAll",
    query = "SELECT c FROM TypeSessionPratique c"),
    @NamedQuery(name = "TypeSessionPratique.getById", 
        query = "SELECT c FROM TypeSessionPratique c WHERE c.id = :id"),
    @NamedQuery(name = "TypeSessionPratique.getByTypeName", 
        query = "SELECT c FROM TypeSessionPratique c WHERE c.typeName = :typeName")
})
public class TypeSessionPratique implements Serializable {
    @Id
    private Long id;
    private String typeName;
    //SESSION_INITIAL, SESSION_PERFECTIONNEMENT;
    private int maxAvailablePlaces;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxAvailablePlaces() {
        return maxAvailablePlaces;
    }

    public void setMaxAvailablePlaces(int maxAvailablePlaces) {
        this.maxAvailablePlaces = maxAvailablePlaces;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TypeSessionPratique other = (TypeSessionPratique) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
    
    
}
