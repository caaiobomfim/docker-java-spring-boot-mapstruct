package caaiobomfim.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Book {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String language;
    private LocalDate publishedDate;

}