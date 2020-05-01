package com.daunkoding.cqrs.cqrsmysqlelasticsearch.controller;

import com.daunkoding.cqrs.cqrsmysqlelasticsearch.document.ProductDocument;
import com.daunkoding.cqrs.cqrsmysqlelasticsearch.entity.Product;
import com.daunkoding.cqrs.cqrsmysqlelasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ResponseEntity<Page<ProductDocument>> data() {
        return ResponseEntity.ok(productService.getPaginated());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDocument> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.create(product));
    }

}
