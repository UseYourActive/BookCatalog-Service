package com.bookstore.bookcatalogservice.operations.find.bytitle;

import com.bookstore.bookcatalogservice.base.OperationOutput;
import com.bookstore.bookcatalogservice.operations.BookResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Schema(
        description = "Book Response DTO for finding by title."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class FindBooksByTitleResponse implements OperationOutput {
    @Schema(
            description = "List of Book Response DTOs."
    )
    private List<BookResponseDTO> bookResponseDTOList;
}
