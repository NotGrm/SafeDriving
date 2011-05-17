/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import com.safedriving.enumeration.TypeExam;
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Ehres
 */
@Entity
@DiscriminatorValue(value="Examen")
public class Examen extends SessionFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    private TypeExam typeExamen;
    private boolean reussi;

    public boolean isReussi() {
        return reussi;
    }

    public void setReussi(boolean reussi) {
        this.reussi = reussi;
    }

    public TypeExam getTypeExamen() {
        return typeExamen;
    }

    public void setTypeExamen(TypeExam typeExamen) {
        this.typeExamen = typeExamen;
    }

    @Override
    public String toString() {
        return "com.safedriving.model.Examen[ id=" + getId() + " ]";
    }
    
}
