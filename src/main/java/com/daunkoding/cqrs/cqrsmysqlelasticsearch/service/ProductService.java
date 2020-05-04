package com.daunkoding.cqrs.cqrsmysqlelasticsearch.service;

import com.daunkoding.cqrs.cqrsmysqlelasticsearch.document.CategoryDocument;
import com.daunkoding.cqrs.cqrsmysqlelasticsearch.document.ProductDocument;
import com.daunkoding.cqrs.cqrsmysqlelasticsearch.entity.Category;
import com.daunkoding.cqrs.cqrsmysqlelasticsearch.entity.Product;
import com.daunkoding.cqrs.cqrsmysqlelasticsearch.repository.ProductDocumentRepository;
import com.daunkoding.cqrs.cqrsmysqlelasticsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDocumentRepository productDocumentRepository;

    @Transactional
    public ProductDocument create(Product product) {
        if (product.getCategory() != null) {
            product.setCategoryId(product.getCategory().getId());
        }
        Product savedProduct = productRepository.save(product);
        Category category = savedProduct.getCategory();
        CategoryDocument categoryDocument = CategoryDocument.builder()
                .id(category.getId())
                .title(category.getTitle())
                .build();
        ProductDocument productDocument = ProductDocument.builder()
                .id(savedProduct.getId())
                .title(savedProduct.getTitle())
                .description(savedProduct.getDescription())
                .price(savedProduct.getPrice())
                .createdAt(savedProduct.getCreatedAt().toString())
                .updatedAt(savedProduct.getUpdatedAt().toString())
                .category(categoryDocument)
                .build();
        return productDocumentRepository.save(productDocument);
    }

    public Page<ProductDocument> getPaginated() {
        return productDocumentRepository.findAll(PageRequest.of(0, 10));
    }
}
