package com.daunkoding.cqrs.cqrsmysqlelasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "store", type = "category")
public class CategoryDocument {
    @Id
    private Integer id;

    private String title;
}
