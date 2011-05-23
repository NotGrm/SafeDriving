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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Ehres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Article.findAll",
    query = "SELECT c FROM Article c"
        + " ORDER BY c.datePublication DESC"),
    @NamedQuery(name = "Article.findByAuthor",
    query = "SELECT c FROM Article c WHERE c.auteur = :name"),
    @NamedQuery(name = "Article.findByTag",
    query = "SELECT c FROM Article c WHERE c.tag = :tag"),
    @NamedQuery(name = "Article.getById",
    query = "SELECT c FROM Article c WHERE c.id = :id")
})
@DiscriminatorValue(value = "Article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String text;
    @ManyToOne
    private Personnel auteur;
    private String Categorie;
    private String tag;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePublication;

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date date) {
        this.datePublication = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    public Personnel getAuteur() {
        return auteur;
    }

    public void setAuteur(Personnel auteur) {
        this.auteur = auteur;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.safedriving.model.Article[ id=" + id + " ]";
    }
}
