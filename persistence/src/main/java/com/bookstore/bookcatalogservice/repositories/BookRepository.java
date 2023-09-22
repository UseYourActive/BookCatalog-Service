package com.bookstore.bookcatalogservice.repositories;

import com.bookstore.bookcatalogservice.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findBookById(UUID id);
    @Query(value = """
            SELECT *
            FROM books i
            WHERE i.title REGEXP :regex
            ORDER BY i.title ASC
            """,
            nativeQuery = true)
    Page<Book> findBooksByTitle(String regex, Pageable pageable);
}
