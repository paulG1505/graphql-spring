package com.paul.graphql.repositories;

import com.paul.graphql.documents.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
}
