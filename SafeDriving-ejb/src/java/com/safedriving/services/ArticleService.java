/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Article;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public List<Article> getAllArticle() {
        Query q = em.createNamedQuery("Article.getAll");
        return (List<Article>) q.getResultList();
    }

    public Article getArticle(int id) {

        Query q = em.createNamedQuery("Article.getById");
        q.setParameter("name", id);
        return (Article) q.getResultList().get(0);
    }

    public Article getArticleByTitle(String title) {
        Query q = em.createNamedQuery("Article.getByTitle");
        q.setParameter("name", title);
        return (Article) q.getResultList().get(0);
    }

    public Article getArticleByAuthor(String author) {
        Query q = em.createNamedQuery("Article.getByAuthor");
        q.setParameter("name", author);
        return (Article) q.getResultList().get(0);
    }

    public List<Article> getArticleByTag(String tag) {
        Query q = em.createNamedQuery("Article.getById");
        q.setParameter("name", tag);
        return q.getResultList();
    }
    
}
