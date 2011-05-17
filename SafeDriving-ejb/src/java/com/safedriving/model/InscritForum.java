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
@DiscriminatorValue(value="incritForum")
public class InscritForum extends Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
   
    @Override
    public String toString() {
        return "com.safedriving.model.InscritForum[ id=" + getId() + " ]";
    }
    
}
