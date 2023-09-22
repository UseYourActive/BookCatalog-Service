package com.bookstore.bookcatalogservice.processors;

import com.bookstore.bookcatalogservice.entities.Book;
import com.bookstore.bookcatalogservice.exceptions.BookNotFoundException;
import com.bookstore.bookcatalogservice.operations.delete.DeleteBookOperation;
import com.bookstore.bookcatalogservice.operations.delete.DeleteBookRequest;
import com.bookstore.bookcatalogservice.operations.delete.DeleteBookResponse;
import com.bookstore.bookcatalogservice.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteBookOperationProcessor implements DeleteBookOperation {
    private final BookRepository bookRepository;

    @Override
    public DeleteBookResponse process(final DeleteBookRequest request) {
        log.info("Processing request to delete a book.");

        String bookId = request.getBookId();
        log.info("Processing request to delete book with ID: {}", bookId);

        Book book = bookRepository.findBookById(UUID.fromString(bookId))
                .orElseThrow(() -> {
                    log.error("Book not found with ID: {}", bookId);
                    return new BookNotFoundException();
                });

        bookRepository.delete(book);
        log.info("Deleted book with ID: {}", bookId);

        return DeleteBookResponse.builder()
                .isSuccess("Successfully deleted book by id: " + bookId)
                .build();
    }
}
