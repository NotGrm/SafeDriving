/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import com.safedriving.model.blog.Article;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Ehres
 */
@Entity
@DiscriminatorValue(value = "Personnel")
@NamedQuery(name = "Personnel.GetByCodPers", query = "SELECT c FROM Personnel c WHERE c.codePersonnel = :code")
public class Personnel extends Personne {

    private String codePersonnel;
    @OneToMany(mappedBy = "auteur")
    private List<Article> listArticle;

    public List<Article> getListArticle() {
        return listArticle;
    }

    public void setListArticle(List<Article> listArticle) {
        this.listArticle = listArticle;
    }

    public String getCodePersonnel() {
        return codePersonnel;
    }

    public void setCodePersonnel(String codePersonnel) {
        this.codePersonnel = codePersonnel;
    }

    @Override
    public String toString() {
        return "com.safedriving.model.Personnel[ id=" + getId() + " ]";
    }
}
