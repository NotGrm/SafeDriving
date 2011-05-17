/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import com.safedriving.enumeration.Service;
import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Ehres
 */
@Entity
@DiscriminatorValue(value="Personnel")
public class Personnel extends Personne implements Serializable {
    private static final long serialVersionUID = 1L;

    private long numPersonnel;
    private Service service;
    private List<Article> listArticle;

    public List<Article> getListArticle() {
        return listArticle;
    }

    public void setListArticle(List<Article> listArticle) {
        this.listArticle = listArticle;
    }

    public long getNumPersonnel() {
        return numPersonnel;
    }

    public void setNumPersonnel(long numPersonnel) {
        this.numPersonnel = numPersonnel;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
    @Override
    public String toString() {
        return "com.safedriving.model.Personnel[ id=" + getId() + " ]";
    }
    
}
