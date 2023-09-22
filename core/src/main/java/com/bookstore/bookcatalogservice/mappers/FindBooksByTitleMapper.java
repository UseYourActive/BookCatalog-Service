package com.bookstore.bookcatalogservice.mappers;

import com.bookstore.bookcatalogservice.entities.Book;
import com.bookstore.bookcatalogservice.operations.BookResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface FindBooksByTitleMapper {
    FindBooksByTitleMapper INSTANCE = Mappers.getMapper(FindBooksByTitleMapper.class);

    @Mapping(target = "bookId", source = "id")
    BookResponseDTO mapToResponse(Book input);
}
