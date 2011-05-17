/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import com.safedriving.enumeration.TypeSessionPratique;
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ehres
 */
@Entity
@DiscriminatorValue(value="Pratique")
public class Pratique extends SessionFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    private Formation formation;
    private Vehicule vehicule;
    private int Note;
    private TypeSessionPratique type;

    public int getNote() {
        return Note;
    }

    public void setNote(int Note) {
        this.Note = Note;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
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
