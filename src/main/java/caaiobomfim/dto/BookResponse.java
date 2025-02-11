package caaiobomfim.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String language;
    private String publishedDate;

}