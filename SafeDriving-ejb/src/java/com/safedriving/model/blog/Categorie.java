/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model.blog;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Grm
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Categorie.getById", query="SELECT c from Categorie c where c.id = :id"),
    @NamedQuery(name="Categorie.getAll", query="SELECT c from Categorie c"),
    @NamedQuery(name="Categorie.getAllFirstLevel", query="SELECT c from Categorie c where c.parent IS NULL")
})
public class Categorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String name;
    
    @OneToOne
    private Categorie parent;
    @OneToMany(cascade= CascadeType.ALL)
    private List<Categorie> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Categorie> getChildren() {
        return children;
    }

    public void setChildren(List<Categorie> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categorie getParent() {
        return parent;
    }

    public void setParent(Categorie parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categorie other = (Categorie) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
    
    

    @Override
    public String toString() {
        return "com.safedriving.model.blog.Class[ id=" + id + " ]";
    }
    
}
