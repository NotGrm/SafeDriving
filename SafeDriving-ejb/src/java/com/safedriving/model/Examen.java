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
@NamedQueries({
    @NamedQuery(name = "Examen.getAll",
    query = "SELECT c FROM Examen c"),
    @NamedQuery(name = "Examen.getById",
    query = "SELECT c FROM Examen c WHERE c.id = :id"),
    @NamedQuery(name = "Examen.getByEmpty",
    query = "SELECT c FROM Examen c WHERE c.nbrMaxPlace = :name")
})
@DiscriminatorValue(value="Examen")
public class Examen extends SessionFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private TypeExamen typeExamen;
    private boolean reussi;

    public boolean isReussi() {
        return reussi;
    }

    public void setReussi(boolean reussi) {
        this.reussi = reussi;
    }

    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    public void setTypeExamen(TypeExamen typeExamen) {
        this.typeExamen = typeExamen;
    }

    @Override
    public String toString() {
        return "com.safedriving.model.Examen[ id=" + getId() + " ]";
    }
}
