package com.bookstore.bookcatalogservice.controllers;

import com.bookstore.bookcatalogservice.operations.create.CreateNewBookOperation;
import com.bookstore.bookcatalogservice.operations.create.CreateNewBookRequest;
import com.bookstore.bookcatalogservice.operations.create.CreateNewBookResponse;
import com.bookstore.bookcatalogservice.operations.delete.DeleteBookOperation;
import com.bookstore.bookcatalogservice.operations.delete.DeleteBookRequest;
import com.bookstore.bookcatalogservice.operations.delete.DeleteBookResponse;
import com.bookstore.bookcatalogservice.operations.edit.full.EditFullBookOperation;
import com.bookstore.bookcatalogservice.operations.edit.full.EditFullBookRequest;
import com.bookstore.bookcatalogservice.operations.edit.full.EditFullBookResponse;
import com.bookstore.bookcatalogservice.operations.find.all.FindAllBooksOperation;
import com.bookstore.bookcatalogservice.operations.find.all.FindAllBooksRequest;
import com.bookstore.bookcatalogservice.operations.find.all.FindAllBooksResponse;
import com.bookstore.bookcatalogservice.operations.find.byid.FindBookByIdOperation;
import com.bookstore.bookcatalogservice.operations.find.byid.FindBookByIdRequest;
import com.bookstore.bookcatalogservice.operations.find.byid.FindBookByIdResponse;
import com.bookstore.bookcatalogservice.operations.find.bytitle.FindBooksByTitleOperation;
import com.bookstore.bookcatalogservice.operations.find.bytitle.FindBooksByTitleRequest;
import com.bookstore.bookcatalogservice.operations.find.bytitle.FindBooksByTitleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Book Resource",
        description = "CRUD REST APIs - Create book, Update book, Find book, Find all books, Delete book"
)
@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping(path = "/books")
public class BookController {
    private final CreateNewBookOperation createNewBookOperation;
    private final FindBookByIdOperation findBookByIdOperation;
    private final FindAllBooksOperation findAllBooksOperation;
    private final FindBooksByTitleOperation findBooksByTitleOperation;
    private final EditFullBookOperation editFullBookOperation;
    private final DeleteBookOperation deleteBookOperation;

    //region GET
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found a book."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database book.",
            summary = "Finds a book by id.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<FindBookByIdResponse> findBookById(@PathVariable(value = "id") @UUID String input) {
        FindBookByIdRequest request = FindBookByIdRequest.builder()
                .bookId(input)
                .build();

        return new ResponseEntity<>(findBookByIdOperation.process(request), HttpStatus.OK);
    }

    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found all books."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users finds all books in the database.",
            summary = "Find all books.")
    @GetMapping(path = "/find-all")
    public ResponseEntity<FindAllBooksResponse> findAllBooks(@RequestParam(defaultValue = "1") Integer pageNumber,
                                                             @RequestParam(defaultValue = "2") Integer numberOfBooksPerPage) {
        FindAllBooksRequest request = FindAllBooksRequest.builder()
                .pageNumber(pageNumber)
                .numberOfBooksPerPage(numberOfBooksPerPage)
                .build();

        return new ResponseEntity<>(findAllBooksOperation.process(request), HttpStatus.OK);
    }

    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found all books with requested title."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds all books related with the title input.",
            summary = "Finds all books with the requested title.")
    @GetMapping(path = "/find-by-title")
    public ResponseEntity<FindBooksByTitleResponse> findBooksByTitle(@RequestParam String title,
                                                                     @RequestParam(defaultValue = "1") Integer pageNumber,
                                                                     @RequestParam(defaultValue = "2") Integer numberOfBooksPerPage) {
        FindBooksByTitleRequest request = FindBooksByTitleRequest.builder()
                .title(title)
                .pageNumber(pageNumber)
                .numberOfBooksPerPage(numberOfBooksPerPage)
                .build();

        return new ResponseEntity<>(findBooksByTitleOperation.process(request), HttpStatus.OK);
    }
    //endregion

    //region POST
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully create a book."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request creates a new book that does not exist in the database yet.",
            summary = "Creates a new book.")
    @PostMapping(path = "/create")
    public ResponseEntity<CreateNewBookResponse> createNewBook(@Valid @RequestBody CreateNewBookRequest request) {
        return new ResponseEntity<>(createNewBookOperation.process(request), HttpStatus.CREATED);
    }
    //endregion

    //region PUT
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully edited a book."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database book and updates it.",
            summary = "Edits a book.")
    @PatchMapping(path = "/edit")
    public ResponseEntity<EditFullBookResponse> editBook(@Valid @RequestBody EditFullBookRequest request) {
        return new ResponseEntity<>(editFullBookOperation.process(request), HttpStatus.OK);
    }
    //endregion

    //region DELETE
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted a book."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database book and deletes it.",
            summary = "Deletes a book.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DeleteBookResponse> deleteBook(@PathVariable("id") @UUID String input) {
        DeleteBookRequest request = DeleteBookRequest.builder()
                .bookId(input)
                .build();

        return new ResponseEntity<>(deleteBookOperation.process(request), HttpStatus.OK);
    }
    //endregion
}
