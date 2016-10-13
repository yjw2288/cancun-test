package com.cancun.repository;

import com.cancun.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ArticleRepository extends JpaRepository<Article, Long>, QueryDslPredicateExecutor<Article> {
}
