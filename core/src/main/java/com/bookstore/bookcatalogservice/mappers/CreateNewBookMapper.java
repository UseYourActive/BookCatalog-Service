package com.bookstore.bookcatalogservice.mappers;

import com.bookstore.bookcatalogservice.entities.Book;
import com.bookstore.bookcatalogservice.operations.create.CreateNewBookRequest;
import com.bookstore.bookcatalogservice.operations.create.CreateNewBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateNewBookMapper {
    CreateNewBookMapper INSTANCE = Mappers.getMapper(CreateNewBookMapper.class);

    @Mapping(target = "bookId", source = "id")
    CreateNewBookResponse mapToResponse(Book input);

    Book mapToEntity(CreateNewBookRequest input);
}
