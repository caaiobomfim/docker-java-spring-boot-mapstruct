package caaiobomfim.controller;

import caaiobomfim.domain.Book;
import caaiobomfim.dto.BookRequest;
import caaiobomfim.dto.BookResponse;
import caaiobomfim.mapper.BookMapper;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final AtomicLong idGenerator = new AtomicLong(1);

    @PostMapping
    public BookResponse createBook(@RequestBody @Valid BookRequest bookRequest) {
        logger.info("Received request to create book: {}", bookRequest);
        Book book = BookMapper.INSTANCE.toBook(bookRequest);
        book.setId(idGenerator.getAndIncrement());
        logger.info("Book mapped and assigned ID: {}", book);
        BookResponse response = BookMapper.INSTANCE.toBookResponse(book);
        logger.info("Returning response: {}", response);
        return response;
    }
}