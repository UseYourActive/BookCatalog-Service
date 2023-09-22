package com.bookstore.bookcatalogservice.processors;

import com.bookstore.bookcatalogservice.entities.Book;
import com.bookstore.bookcatalogservice.exceptions.BookNotFoundException;
import com.bookstore.bookcatalogservice.mappers.FindBookByIdMapper;
import com.bookstore.bookcatalogservice.operations.find.byid.FindBookByIdOperation;
import com.bookstore.bookcatalogservice.operations.find.byid.FindBookByIdRequest;
import com.bookstore.bookcatalogservice.operations.find.byid.FindBookByIdResponse;
import com.bookstore.bookcatalogservice.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class FindBookByIdOperationProcessor implements FindBookByIdOperation {
    private final BookRepository bookRepository;
    private final FindBookByIdMapper findBookByIdMapper;

    @Override
    public FindBookByIdResponse process(final FindBookByIdRequest request) {
        log.info("Processing request to find book by id.");

        String bookId = request.getBookId();
        log.info("Finding book by ID: {}", bookId);

        Book foundBook = bookRepository.findBookById(UUID.fromString(bookId))
                .orElseThrow(BookNotFoundException::new);
        log.info("Found book: {}", foundBook);

        FindBookByIdResponse response = findBookByIdMapper.INSTANCE.mapToResponse(foundBook);
        log.info("Mapped book to response: {}", response);

        return response;
    }
}
