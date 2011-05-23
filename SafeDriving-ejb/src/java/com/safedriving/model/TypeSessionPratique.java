/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Ehres
 */

@Entity
public class TypeSessionPratique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String TypeSessionName;
    //SESSION_INITIAL, SESSION_PERFECTIONNEMENT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeSessionName() {
        return TypeSessionName;
    }

    public void setTypeSessionName(String TypeSessionName) {
        this.TypeSessionName = TypeSessionName;
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
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
    
}
