package com.bookstore.bookcatalogservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "books")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "resume", nullable = false)
    private String resume;

    @Column(name = "author_id", nullable = false)
    private UUID authorId;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "publisher_id", nullable = false)
    private UUID publisherId;
}
