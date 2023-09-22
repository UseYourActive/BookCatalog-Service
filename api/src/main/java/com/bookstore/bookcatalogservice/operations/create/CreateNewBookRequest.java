package com.bookstore.bookcatalogservice.operations.create;

import com.bookstore.bookcatalogservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Schema(
        description = "Book Request DTO for creating a new book."
)
@Getter
@AllArgsConstructor
public final class CreateNewBookRequest implements OperationInput {
    @Schema(
            description = "Book title"
    )
    @NotEmpty(message = "Title should not be null or empty!")
    private final String title;

    @Schema(
            description = "Book resume"
    )
    @NotEmpty(message = "Resume should not be null or empty!")
    private final String resume;

    @Schema(
            description = "Book ISBN"
    )
    @NotEmpty(message = "ISBN should not be null or empty!")
    private final String isbn;

    @Schema(
            description = "Book Author id"
    )
    @UUID
    private final String authorId;

    @Schema(
            description = "Book Publisher id"
    )
    @UUID
    private final String publisherId;
}
