package caaiobomfim.mapper;

import caaiobomfim.domain.Book;
import caaiobomfim.dto.BookRequest;
import caaiobomfim.dto.BookResponse;
import caaiobomfim.util.DateConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateConverter.class})
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "isbn", source = "isbn")
    @Mapping(target = "language", source = "language")
    @Mapping(target = "publishedDate", source = "publishedDate", qualifiedByName = "parseDate")
    Book toBook(BookRequest bookRequest);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "isbn", source = "isbn")
    @Mapping(target = "language", ignore = true)
    @Mapping(target = "publishedDate", source = "publishedDate", qualifiedByName = "formatDate")
    BookResponse toBookResponse(Book book);

}