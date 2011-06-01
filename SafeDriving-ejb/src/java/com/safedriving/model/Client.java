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
import javax.persistence.OneToOne;

/**
 *
 * @author Ehres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Client.getNumClient",
    query = "SELECT c FROM Client c WHERE c.numClient = :num")
})
@DiscriminatorValue(value="Client")
public class Client extends Personne implements Serializable {
    @OneToOne
    private Formation formation;
    private static final long serialVersionUID = 1L;
    private long numClient;

    public long getNumClient() {
        return numClient;
    }

    public void setNumClient(long numClient) {
        this.numClient = numClient;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
    
    @Override
    public String toString() {
        return "com.safedriving.model.Client[ id=" + getId() + " ]";
    }
    
}
