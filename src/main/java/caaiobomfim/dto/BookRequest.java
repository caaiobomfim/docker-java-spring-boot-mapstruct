package caaiobomfim.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    private String author;

    @NotBlank(message = "ISBN cannot be empty")
    private String isbn;

    @NotBlank(message = "Language cannot be empty")
    private String language;

    @NotBlank(message = "Published date cannot be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String publishedDate;

}