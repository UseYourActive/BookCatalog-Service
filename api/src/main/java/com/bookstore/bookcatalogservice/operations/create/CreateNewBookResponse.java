package com.bookstore.bookcatalogservice.operations.create;

import com.bookstore.bookcatalogservice.base.OperationOutput;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "Book Response DTO for creating a new book."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class CreateNewBookResponse implements OperationOutput {
    @Schema(
            description = "Book id"
    )
    private String bookId;

    @Schema(
            description = "Book title"
    )
    private String title;

    @Schema(
            description = "Book resume"
    )
    private String resume;

    @Schema(
            description = "Book ISBN"
    )
    private String isbn;

    @Schema(
            description = "Book Author id"
    )
    private String authorId;

    @Schema(
            description = "Book Publisher id"
    )
    private String publisherId;
}
