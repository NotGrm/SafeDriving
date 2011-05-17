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
@DiscriminatorValue(value="Client")
public class Client extends Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    private long numClient;
    private InscritForum compteForum;
    private SessionFormation session;

    public InscritForum getCompteForum() {
        return compteForum;
    }

    public void setCompteForum(InscritForum compteForum) {
        this.compteForum = compteForum;
    }

    public long getNumClient() {
        return numClient;
    }

    public void setNumClient(long numClient) {
        this.numClient = numClient;
    }

    public SessionFormation getSession() {
        return session;
    }

    public void setSession(SessionFormation session) {
        this.session = session;
    }
    
    @Override
    public String toString() {
        return "com.safedriving.model.Client[ id=" + getId() + " ]";
    }
    
}
