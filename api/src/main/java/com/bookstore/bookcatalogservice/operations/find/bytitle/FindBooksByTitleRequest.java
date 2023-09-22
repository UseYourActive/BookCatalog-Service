package com.bookstore.bookcatalogservice.operations.find.bytitle;

import com.bookstore.bookcatalogservice.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Schema(
        description = "Book Request DTO for finding by title."
)
@Getter
@Builder
@AllArgsConstructor
public final class FindBooksByTitleRequest implements OperationInput {
    private final String title;
    private final Integer pageNumber;
    private final Integer numberOfBooksPerPage;
}
