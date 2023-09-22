package com.bookstore.bookcatalogservice.operations.delete;

import com.bookstore.bookcatalogservice.base.OperationOutput;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "Book Request DTO for deleting a book by id."
)
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class DeleteBookResponse implements OperationOutput {
    @Schema(
            description = "Status of event"
    )
    private String isSuccess;
}
