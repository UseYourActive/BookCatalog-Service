package com.bookstore.bookcatalogservice.operations.edit.full;

import com.bookstore.bookcatalogservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Schema(
        description = "Book Request DTO for fully editing a book by id."
)
@Getter
@Builder
@AllArgsConstructor
public final class EditFullBookRequest implements OperationInput {
    @org.hibernate.validator.constraints.UUID
    @Schema(
            description = "Book id"
    )
    @NotEmpty(message = "Book Id should not be null or empty!")
    private final String bookId;

    @Schema(
            description = "Book title"
    )
    @Nullable
    private final String title;

    @Schema(
            description = "Book resume"
    )
    @Nullable
    private final String resume;

    @org.hibernate.validator.constraints.UUID
    @Schema(
            description = "Book author id"
    )
    @Nullable
    private final String authorId;

    @Schema(
            description = "Book isbn"
    )
    @Nullable
    private final String isbn;

    @org.hibernate.validator.constraints.UUID
    @Schema(
            description = "Book publisher id"
    )
    @Nullable
    private final String publisherId;
}
