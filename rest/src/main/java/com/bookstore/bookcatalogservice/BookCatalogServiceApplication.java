package com.bookstore.bookcatalogservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.bookstore.bookcatalogservice"})
@EntityScan(basePackages = {"com.bookstore.bookcatalogservice.entities"})
@EnableJpaRepositories(basePackages = {"com.bookstore.bookcatalogservice.repositories"})
@EnableFeignClients()
@OpenAPIDefinition(
        info = @Info(
                title = "Book Catalog Service Documentation",
                description = "This is a documentation for my book catalog service",
                version = "v1.0",
                contact = @Contact(
                        name = "Alex Orozov",
                        email = "alexorozov@gmail.com",
                        url = "https://www.linkedin.com/in/alex-orozov-34440624b/"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.linkedin.com/in/alex-orozov-34440624b/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot Book Catalog Service",
                url = "https://www.linkedin.com/in/alex-orozov-34440624b/BookCatalog-Service.html"
        )
)
public class BookCatalogServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookCatalogServiceApplication.class, args);
    }
}
