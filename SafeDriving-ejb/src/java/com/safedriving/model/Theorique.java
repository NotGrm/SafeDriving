/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Ehres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Theorique.getById",
    query = "SELECT c FROM Theorique c WHERE c.id = :id"),
    @NamedQuery(name = "Theorique.getAll",
    query = "SELECT c FROM Theorique c"),
    @NamedQuery(name = "Theorique.getByLieu",
    query = "SELECT c FROM Theorique c WHERE c.lieu = :lieu"),
    @NamedQuery(name = "Theorique.getByIntervenant",
    query = "SELECT c FROM Theorique c WHERE c.intervenant = :inter")
})
@DiscriminatorValue(value="Theorie")
public class Theorique extends SessionFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int score;
    private int difficulte;

    public Theorique() {
    }

    public Theorique(SessionFormation s) {
        this.dateSession = s.dateSession;
        this.duree = s.duree;
        this.heureDebut = s.heureDebut;
        this.intervenant = s.intervenant;
        this.lieu = s.lieu;
        this.nbrMaxPlace = s.nbrMaxPlace;
        this.participants = s.participants;
    }
    
    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
