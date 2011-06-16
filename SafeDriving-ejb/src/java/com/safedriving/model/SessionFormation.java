/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Ehres
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeSession")
@NamedQueries({
    @NamedQuery(name="SessionFormation.getById", 
        query="Select c from SessionFormation c where c.id = :id"),
    @NamedQuery(name="SessionFormation.findByIntervenant", 
        query="Select c from SessionFormation c where c.intervenant = :intervenant"),
    @NamedQuery(name="SessionFormation.findAllAfterDate", 
        query="Select c from SessionFormation c where c.dateSession > :date")
})

public class SessionFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nbrMaxPlace;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSession;
    @ManyToOne
    private Lieu lieu;
    @ManyToOne
    private Personnel intervenant;  
    @OneToMany
    private List<Client> participants;
    private int duree;
    private int heureDebut;

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDure(int duree) {
        this.duree = duree;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return dateSession;
    }

    public void setDate(Date date) {
        this.dateSession = date;
    }

    public Personnel getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Personnel intervenant) {
        this.intervenant = intervenant;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public List<Client> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Client> participants) {
        this.participants = participants;
    }

    public int getNbrMaxPlace() {
        return nbrMaxPlace;
    }

    public void setNbrMaxPlace(int nbrMaxPlace) {
        this.nbrMaxPlace = nbrMaxPlace;
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
        if (!(object instanceof SessionFormation)) {
            return false;
        }
        SessionFormation other = (SessionFormation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.safedriving.model.Session[ id=" + id + " ]";
    }
    
}
