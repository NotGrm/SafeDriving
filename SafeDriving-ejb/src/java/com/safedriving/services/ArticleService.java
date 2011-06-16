/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.blog.Article;
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
    public void add(Article article) {
        em.persist(article);
    }

    @Override
    public void remove(Article article) {
        em.remove(article);
    }

    @Override
    public void refresh(Article article) {
        em.merge(article);
    }

    @Override
    public List<Article> getAll() {
        Query q = em.createNamedQuery("Article.getAll");
        return (List<Article>) q.getResultList();
    }

    @Override
    public Article getById(long id) {
        return em.find(Article.class, id);
    }

    @Override
    public List<Article> getByAuthor(String author) {
        Query q = em.createNamedQuery("Article.getByAuthor");
        q.setParameter("name", author);
        return (List<Article>) q.getResultList().get(0);
    }

    @Override
    public List<Article> getByTag(String tag) {
        Query q = em.createNamedQuery("Article.getById");
        q.setParameter("name", tag);
        return q.getResultList();
    }
}
