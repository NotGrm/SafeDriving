/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ehres
 */
@Entity
@DiscriminatorValue(value="Pratique")
public class Pratique extends SessionFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int Note;
    @ManyToOne
    private TypeSessionPratique type;
    @ManyToOne
    private Vehicule vehicule;
    
    public int getNote() {
        return Note;
    }

    public void setNote(int Note) {
        this.Note = Note;
    }

    public TypeSessionPratique getType() {
        return type;
    }

    public void setType(TypeSessionPratique type) {
        this.type = type;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public String toString() {
        return "com.safedriving.model.Pratique[ id=" + getId() + " ]";
    }
    
}
