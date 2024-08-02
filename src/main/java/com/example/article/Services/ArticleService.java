package com.example.article.Services;

import com.example.article.Article.model.Article;
import com.example.article.Controller.ArticleController;

import java.util.List;

public interface ArticleService {
    Article createArticle(Article article);

    Article updateArticle(Article article);

    List<Article> getAllArticle();

    Article getArticleById(Long id);

    void deleteArticle(Long id);
}







