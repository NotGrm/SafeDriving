/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Ehres
 */
@Entity
@DiscriminatorValue(value="Theorie")
public class Theorique extends SessionFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int score;
    private int difficulte;

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

    @Override
    public String toString() {
        return "com.safedriving.model.Theorique[ id=" + getId() + " ]";
    }
    
}
