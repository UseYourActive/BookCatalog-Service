package com.bookstore.bookcatalogservice.processors;

import com.bookstore.bookcatalogservice.entities.Book;
import com.bookstore.bookcatalogservice.mappers.CreateNewBookMapper;
import com.bookstore.bookcatalogservice.operations.create.CreateNewBookOperation;
import com.bookstore.bookcatalogservice.operations.create.CreateNewBookRequest;
import com.bookstore.bookcatalogservice.operations.create.CreateNewBookResponse;
import com.bookstore.bookcatalogservice.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CreateNewBookOperationProcessor implements CreateNewBookOperation {
    private final BookRepository bookRepository;
    private final CreateNewBookMapper createNewBookMapper;

    @Transactional
    @Override
    public CreateNewBookResponse process(final CreateNewBookRequest request) {
        log.info("Processing request to create a new book.");

        String title = request.getTitle();
        String isbn = request.getIsbn();
        String resume = request.getResume();
        String authorId = request.getAuthorId();
        String publisherId = request.getPublisherId();
        log.info("Creating a new book with title: {}, ISBN: {}, Author ID: {}, Publisher ID: {}, resume: {}", title, isbn, authorId, publisherId, resume);

        Book book = createNewBookMapper.INSTANCE.mapToEntity(request);
        log.debug("Saving the book: {}", book);

        Book persistedBook = bookRepository.save(book);
        log.info("Book saved with ID: {}", persistedBook.getId());

        CreateNewBookResponse response = createNewBookMapper.INSTANCE.mapToResponse(persistedBook);
        log.info("New book created: {}", response);

        return response;
    }
}
