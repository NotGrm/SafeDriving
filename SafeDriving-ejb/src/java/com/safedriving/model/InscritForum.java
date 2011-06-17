/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Ehres
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"userName"})})
@DiscriminatorValue(value = "incritForum")
@NamedQueries({
    @NamedQuery(name = "InscritForum.getByUsername",
    query = "SELECT c from InscritForum AS c WHERE c.username = :username"),
    @NamedQuery(name = "InscritForum.getByUsernamePwd",
    query = "SELECT c from InscritForum c WHERE c.username = :username AND c.password = :password"),
<<<<<<< HEAD
    @NamedQuery(name="InscritForum.getAllByRole", query="Select c from InscritForum c where c.role = :role")
=======
    @NamedQuery(name = "InscritForum.getByRole",
    query = "SELECT c from InscritForum c WHERE c.role = :role")
>>>>>>> 69749ec0905012af16e51992399f9b27b28a4fae
})
public class InscritForum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInscription;
    @OneToOne
    private WebSiteRole role;

    public WebSiteRole getRole() {
        return role;
    }

    public void setRole(WebSiteRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Override
    public String toString() {
        return "com.safedriving.model.InscritForum[ id=" + getId() + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
