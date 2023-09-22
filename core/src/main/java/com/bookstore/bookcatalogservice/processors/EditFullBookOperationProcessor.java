package com.bookstore.bookcatalogservice.processors;

import com.bookstore.bookcatalogservice.entities.Book;
import com.bookstore.bookcatalogservice.exceptions.BookNotFoundException;
import com.bookstore.bookcatalogservice.mappers.EditFullBookMapper;
import com.bookstore.bookcatalogservice.operations.edit.full.EditFullBookOperation;
import com.bookstore.bookcatalogservice.operations.edit.full.EditFullBookRequest;
import com.bookstore.bookcatalogservice.operations.edit.full.EditFullBookResponse;
import com.bookstore.bookcatalogservice.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Consumer;

@Service
@Slf4j
@RequiredArgsConstructor
public class EditFullBookOperationProcessor implements EditFullBookOperation {
    private final BookRepository bookRepository;
    private final EditFullBookMapper editFullBookMapper;

    @Override
    public EditFullBookResponse process(final EditFullBookRequest request) {
        log.info("Processing request to fully edit a book.");

        String bookId = request.getBookId();
        log.info("Processing request to edit book with ID: {}", bookId);

        Book foundBook = bookRepository.findBookById(UUID.fromString(bookId))
                .orElseThrow(BookNotFoundException::new);
        log.debug("Found book: {}", foundBook);

        updateIfNotNull(request.getTitle(), foundBook::setTitle, "Title");
        updateIfNotNull(request.getResume(), foundBook::setResume, "Resume");
        updateIfNotNull(request.getIsbn(), foundBook::setIsbn, "ISBN");
        updateIfNotNull(request.getPublisherId(), publisherId -> foundBook.setPublisherId(UUID.fromString(publisherId)), "Publisher ID");
        updateIfNotNull(request.getAuthorId(), authorId -> foundBook.setAuthorId(UUID.fromString(authorId)), "Author ID");

        EditFullBookResponse response = editFullBookMapper.mapToResponse(foundBook);
        log.info("Book edited successfully with ID: {}", bookId);

        return response;
    }

    private void updateIfNotNull(String value, Consumer<String> setter, String fieldName) {
        if (value != null) {
            setter.accept(value);
            log.debug("{} updated: {}", fieldName, value);
        }
    }
}
