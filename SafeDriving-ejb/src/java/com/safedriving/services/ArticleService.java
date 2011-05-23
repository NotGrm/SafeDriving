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

    @Override
    public void addArticle(Article article) {
        em.persist(article);
    }

    @Override
    public void removeArticle(Article article) {
        em.remove(article);
    }

    @Override
    public void modifieArticle(Article article) {
        em.refresh(article);
    }

    @Override
    public List<Article> getAllArticle() {
        Query q = em.createNamedQuery("Article.findAll");
        return (List<Article>) q.getResultList();
    }

    @Override
    public Article getArticle(long id) {

        Query q = em.createNamedQuery("Article.getById");
        q.setParameter("id", id);
        return (Article) q.getSingleResult();
    }

    @Override
    public Article getArticleByTitle(String title) {
        Query q = em.createNamedQuery("Article.getByTitle");
        q.setParameter("name", title);
        return (Article) q.getSingleResult();
    }

    @Override
    public Article getArticleByAuthor(String author) {
        Query q = em.createNamedQuery("Article.getByAuthor");
        q.setParameter("name", author);
        return (Article) q.getResultList().get(0);
    }

    @Override
    public List<Article> getArticleByTag(String tag) {
        Query q = em.createNamedQuery("Article.getById");
        q.setParameter("name", tag);
        return q.getResultList();
    }
    
}
