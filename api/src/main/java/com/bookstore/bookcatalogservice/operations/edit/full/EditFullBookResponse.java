package com.bookstore.bookcatalogservice.operations.edit.full;

import com.bookstore.bookcatalogservice.base.OperationOutput;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "Book Request DTO for editing a book by id."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class EditFullBookResponse implements OperationOutput {
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
