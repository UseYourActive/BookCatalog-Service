package com.bookstore.bookcatalogservice.mappers;

import com.bookstore.bookcatalogservice.entities.Book;
import com.bookstore.bookcatalogservice.operations.find.byid.FindBookByIdResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FindBookByIdMapper {
    FindBookByIdMapper INSTANCE = Mappers.getMapper(FindBookByIdMapper.class);

    @Mapping(target = "bookId", source = "id")
    FindBookByIdResponse mapToResponse(Book input);
}
