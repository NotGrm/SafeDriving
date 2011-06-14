/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Article;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface ArticleServiceLocal {
    void add(Article article);

    void remove(Article article);

    void refresh(Article article);

    Article getById(long id);

    List<Article> getAll();

    List<Article> getByAuthor(String author);

    List<Article> getByTag(String tag);
} 
