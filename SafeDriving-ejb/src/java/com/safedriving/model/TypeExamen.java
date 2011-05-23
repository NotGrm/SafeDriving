/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Ehres
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "TypeExamen.getAll",
    query = "SELECT c FROM TypeExamen c"),
    @NamedQuery(name = "TypeExamen.getById",
    query = "SELECT c FROM TypeExamen c WHERE c.id = :id")
})
public class TypeExamen implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String TypeString;

    public String getTypeString() {
        return TypeString;
    }

    public void setTypeString(String TypeString) {
        this.TypeString = TypeString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TypeExamen other = (TypeExamen) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return "TypeExamen{" + "id=" + id + ", TypeString=" + TypeString + '}';
    }
    
    
}
