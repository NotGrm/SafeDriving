/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Ehres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Disponibility.getAll",
    query = "SELECT c FROM Disponibility c"),
    @NamedQuery(name = "Disponibility.getByFormateurId",
    query = "SELECT c FROM Disponibility c WHERE c.formateur.id = :id"),
    @NamedQuery(name = "Disponibility.getForUserAtDate",
    query = "Select c from Disponibility c where c.formateur = :user "
        + "and c.dateDebut <= :dateDebut "
        + "and :dateFin <= c.dateFin")
})
public class Disponibility implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Personnel formateur;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFin;

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Personnel getFormateur() {
        return formateur;
    }

    public void setFormateur(Personnel formateur) {
        this.formateur = formateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibility)) {
            return false;
        }
        Disponibility other = (Disponibility) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.safedriving.model.Disponibility[ id=" + id + " ]";
    }
}
