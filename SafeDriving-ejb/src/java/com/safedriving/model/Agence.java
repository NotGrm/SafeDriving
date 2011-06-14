/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Agence.getAll",
    query = "SELECT c FROM Agence c"),
    @NamedQuery(name = "Agence.getByNom",
    query = "SELECT c FROM Agence c WHERE c.nom = :name"),
    @NamedQuery(name = "Agence.getById",
    query = "SELECT c FROM Agence c WHERE c.id = :id")
})
public class Agence implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String nom;
    private String code;
    private String adresse;
    private int codePostal;
    private String ville;
    @OneToMany
    private List<Personnel> employes;    
    @OneToMany
    private List<Vehicule> vehicules;
    @OneToMany
    private List<Lieu> lieux;
    @OneToMany
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public List<Personnel> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Personnel> employes) {
        this.employes = employes;
    }

    public List<Lieu> getLieux() {
        return lieux;
    }

    public void setLieux(List<Lieu> lieux) {
        this.lieux = lieux;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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
        hash += (Long) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Agence)) {
            return false;
        }
        Agence other = (Agence) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supinfo.testprojectdev.model.Personne[ id=" + id + " ]";
    }
}
