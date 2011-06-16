/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Ehres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "ParticipationSession.getAll",
    query = "SELECT c FROM ParticipationSession c"),
    @NamedQuery(name = "ParticipationSession.getByClient",
    query = "SELECT c FROM ParticipationSession c WHERE c.client.id = :id")
})
public class ParticipationSession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private SessionFormation sessionFormation;
    @OneToOne
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public SessionFormation getSessionFormation() {
        return sessionFormation;
    }

    public void setSessionFormation(SessionFormation sessionFormation) {
        this.sessionFormation = sessionFormation;
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
        if (!(object instanceof ParticipationSession)) {
            return false;
        }
        ParticipationSession other = (ParticipationSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.safedriving.model.ParticipationSession[ id=" + id + " ]";
    }
    
}
