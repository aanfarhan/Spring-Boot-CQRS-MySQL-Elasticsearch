package com.daunkoding.cqrs.cqrsmysqlelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CqrsMysqlElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsMysqlElasticsearchApplication.class, args);
    }

}
