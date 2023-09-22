package com.bookstore.bookcatalogservice.processors;

import com.bookstore.bookcatalogservice.entities.Book;
import com.bookstore.bookcatalogservice.mappers.FindBooksByTitleMapper;
import com.bookstore.bookcatalogservice.operations.BookResponseDTO;
import com.bookstore.bookcatalogservice.operations.find.bytitle.FindBooksByTitleOperation;
import com.bookstore.bookcatalogservice.operations.find.bytitle.FindBooksByTitleRequest;
import com.bookstore.bookcatalogservice.operations.find.bytitle.FindBooksByTitleResponse;
import com.bookstore.bookcatalogservice.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class FindBooksByTitleOperationProcessor implements FindBooksByTitleOperation {
    private final BookRepository bookRepository;
    private final FindBooksByTitleMapper findBooksByTitleMapper;

    @Override
    public FindBooksByTitleResponse process(FindBooksByTitleRequest request) {
        log.info("Processing request to find books by title: {}", request.getTitle());

        PageRequest pageRequest = PageRequest.of(
                request.getPageNumber(),
                request.getNumberOfBooksPerPage(),
                Sort.by(Sort.Direction.ASC, "title")); // already sorted in Repository

        Page<Book> booksByTitle = bookRepository.findBooksByTitle(request.getTitle(), pageRequest);
        log.debug("Found {} books by title: {}", booksByTitle.getTotalElements(), request.getTitle());

        List<BookResponseDTO> bookResponseDTOS = booksByTitle.stream()
                .map(findBooksByTitleMapper.INSTANCE::mapToResponse)
                .toList();

        FindBooksByTitleResponse response = FindBooksByTitleResponse.builder()
                .bookResponseDTOList(bookResponseDTOS)
                .build();
        log.info("Found {} books by title: {}", bookResponseDTOS.size(), request.getTitle());

        return response;
    }
}
