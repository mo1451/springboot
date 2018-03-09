package com.mo1451.boot.elasticsearch.service;

import com.mo1451.boot.elasticsearch.dto.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleSearchRepository extends ElasticsearchRepository<Article,Long> {
}
