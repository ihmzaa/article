package com.example.article.Controller;

import com.example.article.Article.model.Article;
import com.example.article.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity <List <Article>> getAllArticle(){
        return ResponseEntity.ok().body(articleService.getAllArticle());
    }

    @GetMapping("{id}")
    public ResponseEntity <Article> getArticleById(@PathVariable Long id){
        return ResponseEntity.ok().body(articleService.getArticleById(id));
    }

    @PostMapping
    public ResponseEntity <Article> createArticle(@RequestBody Article article){
        return ResponseEntity.ok().body(this.articleService.createArticle(article));
    }

    @PutMapping
    public HttpStatus deleteArticle(@PathVariable Long id){
        this.articleService.deleteArticle(id);
        return HttpStatus.OK;
    }

}





/*
 @Autowired
    private ArticleService service;

    @PostMapping("/addArticle")
    public Article addSingleArticle(@RequestBody Article article) {
        return service.saveArticle(article);
    }

    @PostMapping("/addArticles")
    public List<Article> addMultiArticles(@RequestBody List<Article> articles) {
        return service.saveArticles(articles);
    }

    @GetMapping("/articles")
    public List<Article> findAllArticles() {
        return service.getArticles();
    }

    @GetMapping("/articleById/{id}")
    public Article findArticleById(@PathVariable Long id) {
        return service.getArticleById(id);
    }

    @PutMapping("/update")
    public Article updateArticle(@RequestBody Article article) {
        return service.updateArticle(article);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        service.deleteArticle(id);
        return "Article with ID " + id + " has been deleted.";
    }
 */