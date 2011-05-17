/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Article;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ehres
 */
@Stateless
public class ArticleService implements ArticleServiceLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    public void addArticle(Article article) {
        em.persist(article);
    }

    public void removeArticle(Article article) {
        em.remove(article);
    }

    public void modifieArticle(Article article) {
        em.refresh(article);
    }

    public void getArticle(Article article) {
        
    }
    
    
}
