package com.bookstore.bookcatalogservice.operations;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "Book Response DTO."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class BookResponseDTO {
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
