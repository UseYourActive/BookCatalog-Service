package com.bookstore.bookcatalogservice.processors;

import com.bookstore.bookcatalogservice.entities.Book;
import com.bookstore.bookcatalogservice.mappers.FindAllBooksMapper;
import com.bookstore.bookcatalogservice.operations.BookResponseDTO;
import com.bookstore.bookcatalogservice.operations.find.all.FindAllBooksOperation;
import com.bookstore.bookcatalogservice.operations.find.all.FindAllBooksRequest;
import com.bookstore.bookcatalogservice.operations.find.all.FindAllBooksResponse;
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
public class FindAllBooksOperationProcessor implements FindAllBooksOperation {
    private final BookRepository bookRepository;
    private final FindAllBooksMapper findAllBooksMapper;

    @Override
    public FindAllBooksResponse process(final FindAllBooksRequest request) {
        log.info("Processing request to find all books.");

        PageRequest pageRequest = PageRequest.of(
                request.getPageNumber(),
                request.getNumberOfBooksPerPage(),
                Sort.by(Sort.Direction.ASC, "title"));

        Page<Book> allItems = bookRepository.findAll(pageRequest);
        log.debug("Found {} books in the database.", allItems.getTotalElements());

        List<BookResponseDTO> list = allItems.stream()
                .map(findAllBooksMapper.INSTANCE::mapToResponse)
                .toList();
        log.debug("Mapped {} books to response.", list.size());

        FindAllBooksResponse response = FindAllBooksResponse.builder()
                .listOfBookDTO(list)
                .build();
        log.info("Found all books successfully.");

        return response;
    }
}
