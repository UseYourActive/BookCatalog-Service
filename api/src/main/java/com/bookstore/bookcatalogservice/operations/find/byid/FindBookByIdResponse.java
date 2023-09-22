package com.bookstore.bookcatalogservice.operations.find.byid;

import com.bookstore.bookcatalogservice.base.OperationOutput;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "Book Response DTO for finding by id."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class FindBookByIdResponse implements OperationOutput {
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
