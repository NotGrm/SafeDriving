/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.model;

import com.safedriving.model.blog.Article;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Ehres
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Personnel.getAll",
    query = "SELECT c FROM Personnel c"),
    @NamedQuery(name = "Personnel.getByCodPers", 
        query = "SELECT c FROM Personnel c WHERE c.codePersonnel = :code"),
    @NamedQuery(name = "Personnel.getByCompteForum", 
        query = "SELECT c FROM Personnel c WHERE c.compteForum = :compte")
})
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
