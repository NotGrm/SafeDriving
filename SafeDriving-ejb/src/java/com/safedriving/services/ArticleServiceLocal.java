/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Article;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface ArticleServiceLocal {
    void addArticle(Article article);

    void removeArticle(Article article);

    void modifieArticle(Article article);

    void getArticle(Article article);
}
