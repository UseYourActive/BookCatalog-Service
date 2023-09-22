package com.bookstore.bookcatalogservice.operations.find.all;

import com.bookstore.bookcatalogservice.base.OperationOutput;
import com.bookstore.bookcatalogservice.operations.BookResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Schema(
        description = "Book Response DTO with list of book DTOs."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class FindAllBooksResponse implements OperationOutput {
    @Schema(
            description = "List of Book Response DTOs."
    )
    public List<BookResponseDTO> listOfBookDTO;
}
