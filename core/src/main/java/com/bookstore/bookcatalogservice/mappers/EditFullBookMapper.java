package com.bookstore.bookcatalogservice.mappers;

import com.bookstore.bookcatalogservice.entities.Book;
import com.bookstore.bookcatalogservice.operations.edit.full.EditFullBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EditFullBookMapper {
    EditFullBookMapper INSTANCE = Mappers.getMapper(EditFullBookMapper.class);

    @Mapping(target = "bookId", source = "id")
    EditFullBookResponse mapToResponse(Book input);
}
