package com.example.article.Services;

import com.example.article.Article.model.Article;
import com.example.article.Repository.ArticleRepository;
import com.example.article.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository repository;

    @Override
    public Article createArticle(Article article){

        return repository.save(article);
    }
    @Override
    public Article updateArticle(Article article){
        Optional <Article> articleDb = this.repository.findById(article.getId());

        if (articleDb.isPresent()){
            Article articleUpdate = articleDb.get();
            articleUpdate.setId(article.getId());
            articleUpdate.setTitle(article.getTitle());
            articleUpdate.setContent(article.getContent());
            repository.save(articleUpdate);
            return articleUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + article.getId());
        }
    }

    @Override
    public List<Article> getAllArticle() {
        return List.of();
    }

    @Override
    public Article getArticleById(Long id){
        Optional<Article> articleDb = this.repository.findById(id);

        if (articleDb.isPresent()){
            return articleDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
    }

    @Override
    public void deleteArticle(Long id) {

    }
}











/*
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



