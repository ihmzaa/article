package com.example.article.Repository;

import com.example.article.Article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
















/*
package com.example.article.Repository;

import com.example.article.Article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryArticle {

    private final List<Article> articles = new ArrayList<>();
    private long currentId = 1;

    public List<Article> findAll() {
        return new ArrayList<>(articles);
    }

    public Optional<Article> findById(Long id) {
        return articles.stream().filter(article -> article.getId().equals(id)).findFirst();
    }

    public Article save(Article article) {
        if (article.getId() == null) {
            article.setId(currentId++);
        } else {
            articles.removeIf(a -> a.getId().equals(article.getId()));
        }
        articles.add(article);
        return article;
    }

    public List<Article> saveAll(List<Article> articlesToSave) {
        articlesToSave.forEach(this::save);
        return articlesToSave;
    }

    public void deleteById(Long id) {
        articles.removeIf(article -> article.getId().equals(id));
    }
}

 */