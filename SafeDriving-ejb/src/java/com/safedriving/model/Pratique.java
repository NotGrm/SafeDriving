/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Ehres
 */
@Entity
@DiscriminatorValue(value="Pratique")
@NamedQueries({
    @NamedQuery(name = "Pratique.getAll",
    query = "SELECT c FROM Pratique c"),
    @NamedQuery(name = "Pratique.GetByLieu", 
        query = "SELECT c FROM Pratique c WHERE c.lieu = :lieu"),
    @NamedQuery(name = "Pratique.GetByType", 
        query = "SELECT c FROM Pratique c WHERE c.type = :type"),
    @NamedQuery(name = "Pratique.GetByIntervenant", 
        query = "SELECT c FROM Pratique c WHERE c.intervenant = :inter")
})
public class Pratique extends SessionFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int Note;
    @ManyToOne
    private TypeSessionPratique type;
    @ManyToOne
    private Vehicule vehicule;

    public Pratique() {
    }

    public Pratique(SessionFormation s) {
        this.dateSession = s.dateSession;
        this.duree = s.duree;
        this.heureDebut = s.heureDebut;
        this.intervenant = s.intervenant;
        this.lieu = s.lieu;
        this.nbrMaxPlace = s.nbrMaxPlace;
        this.participants = s.participants;
    }
    
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
