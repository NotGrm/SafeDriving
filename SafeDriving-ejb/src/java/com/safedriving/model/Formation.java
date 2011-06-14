/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ehres
 */
@Entity
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(mappedBy = "formation")
    private Client client;  
    private boolean codeObtenu;
    private String dateObtentionCode;
    @OneToMany
    private List<Theorique> sessionTheoriques;
    @OneToMany
    private List<Pratique> SessionPratique;

    public List<Pratique> getSessionPratique() {
        return SessionPratique;
    }

    public void setSessionPratique(List<Pratique> SessionPratique) {
        this.SessionPratique = SessionPratique;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isCodeObtenu() {
        return codeObtenu;
    }

    public void setCodeObtenu(boolean codeObtenu) {
        this.codeObtenu = codeObtenu;
    }

    public String getDateObtentionCode() {
        return dateObtentionCode;
    }

    public void setDateObtentionCode(String dateObtentionCode) {
        this.dateObtentionCode = dateObtentionCode;
    }

    public Examen getExamenCode() {
        return examenCode;
    }

    public void setExamenCode(Examen examenCode) {
        this.examenCode = examenCode;
    }

    public Examen getExamenConduite() {
        return examenConduite;
    }

    public void setExamenConduite(Examen examenConduite) {
        this.examenConduite = examenConduite;
    }

    public List<Theorique> getSessionTheoriques() {
        return sessionTheoriques;
    }

    public void setSessionTheoriques(List<Theorique> sessionTheoriques) {
        this.sessionTheoriques = sessionTheoriques;
    }
    @ManyToOne
    private Examen examenCode;
    @ManyToOne
    private Examen examenConduite;

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
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.safedriving.model.Formation[ id=" + id + " ]";
    }
    
}
