package com.bookstore.bookcatalogservice.operations.find.all;

import com.bookstore.bookcatalogservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Schema(
        description = "Book Request DTO for finding all books."
)
@Getter
@Builder
@AllArgsConstructor
public final class FindAllBooksRequest implements OperationInput {
    @Schema(
            description = "Page number for Pagination"
    )
    @NotEmpty(message = "Page number should not be null or empty!")
    @PositiveOrZero
    private final Integer pageNumber;

    @Schema(
            description = "Number of pages per page for Pagination"
    )
    @NotEmpty(message = "Number of books per page should not be null or empty!")
    @Positive
    private final Integer numberOfBooksPerPage;
}
