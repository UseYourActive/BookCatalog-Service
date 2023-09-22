package com.bookstore.bookcatalogservice.operations.find.byid;

import com.bookstore.bookcatalogservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.UUID;

@Schema(
        description = "Book Request DTO for finding by id."
)
@Getter
@Builder
@AllArgsConstructor
public final class FindBookByIdRequest implements OperationInput {
    @Schema(
            description = "Book id"
    )
    @NotEmpty(message = "Book id should not be null or empty!")
    @UUID
    private final String bookId;
}
