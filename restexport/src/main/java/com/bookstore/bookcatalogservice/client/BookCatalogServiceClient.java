package com.bookstore.bookcatalogservice.client;

import com.bookstore.bookcatalogservice.operations.create.CreateNewBookRequest;
import com.bookstore.bookcatalogservice.operations.create.CreateNewBookResponse;
import com.bookstore.bookcatalogservice.operations.delete.DeleteBookResponse;
import com.bookstore.bookcatalogservice.operations.edit.full.EditFullBookRequest;
import com.bookstore.bookcatalogservice.operations.edit.full.EditFullBookResponse;
import com.bookstore.bookcatalogservice.operations.find.all.FindAllBooksResponse;
import com.bookstore.bookcatalogservice.operations.find.byid.FindBookByIdResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.hibernate.validator.constraints.UUID;
import org.springframework.cloud.openfeign.FeignClient;

@Headers({
        "Content-Type: application/json"
})
@FeignClient(url = "http://localhost:8081", value = "BookCatalog-Service")
public interface BookCatalogServiceClient{
    @RequestLine("GET /books/{id}")
    FindBookByIdResponse findBookById(@Param(value = "id") @UUID String input);

    @RequestLine("GET /books/find-all")
    FindAllBooksResponse findAllBooks(@Param Integer pageNumber,
                                      @Param Integer numberOfBooksPerPage);
    @RequestLine("POST /books/create")
    CreateNewBookResponse createNewBook(@Param CreateNewBookRequest request);

    @RequestLine("PUT /books/edit")
    EditFullBookResponse editBook(@Param EditFullBookRequest request);

    @RequestLine("DELETE /books/{id}")
    DeleteBookResponse deleteBook(@Param("id") @UUID String input);
}
