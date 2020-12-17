package com.paul.graphql.graphql;

import com.paul.graphql.documents.Article;
import com.paul.graphql.repositories.ArticleRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ArticleMutation implements GraphQLMutationResolver {

    public ArticleRepository articleRepository;

    @Autowired
    public ArticleMutation(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article createArticle(Article article) {
        return this.articleRepository.save(article);
    }

    public Article updateArticle(String id, Article article) {
        Optional<Article> articleDb = this.articleRepository.findById(id);
        Article articleUpdate = articleDb.get();
        articleUpdate.setName(article.getName());
        articleUpdate.setPrice(article.getPrice());
        return this.articleRepository.save(articleUpdate);
    }

    public Article deleteArticle(String id) {
        Optional<Article> articleDb = this.articleRepository.findById(id);
        Article article = articleDb.get();
        this.articleRepository.deleteById(id);
        return article;
    }
}
