package com.daunkoding.cqrs.cqrsmysqlelasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "product")
public class ProductDocument {
    @Id
    private Integer id;

    private String title;

    private String description;

    private BigDecimal price;

    @Field(type = FieldType.Auto)
    private String createdAt;

    @Field(type = FieldType.Auto)
    private String updatedAt;

    @Field(type = FieldType.Nested)
    private CategoryDocument category;
}
