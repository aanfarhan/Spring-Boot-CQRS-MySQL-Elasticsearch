package com.daunkoding.cqrs.cqrsmysqlelasticsearch.repository;

import com.daunkoding.cqrs.cqrsmysqlelasticsearch.document.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDocumentRepository extends ElasticsearchCrudRepository<ProductDocument, Integer> {
}
