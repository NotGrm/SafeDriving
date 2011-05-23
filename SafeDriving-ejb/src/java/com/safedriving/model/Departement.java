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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Ehres
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "Departement.getAll",
    query = "SELECT c FROM Departement c"),
    @NamedQuery(name = "Departement.getById",
    query = "SELECT c FROM Departement c WHERE c.id = :id")
})
public class Departement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String departementName;
    //SERVIVE_DIRECTION, SERVICE_REDACTION, SERVICE_GESTION_AGENCE, SERVICE_FORMATION;
    @OneToMany(mappedBy = "service")
    private List<Personnel> personnelService;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartementName() {
        return departementName;
    }

    public void setDepartementName(String departementName) {
        this.departementName = departementName;
    }

    public List<Personnel> getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(List<Personnel> personnelService) {
        this.personnelService = personnelService;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departement other = (Departement) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
    
    
}
