package caaiobomfim.util;

import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // String to LocalDate converter
    @Named("parseDate")
    public static LocalDate parse(String date) {
        return LocalDate.parse(date, INPUT_FORMAT);
    }

    // LocalDate to String converter
    @Named("formatDate")
    public static String format(LocalDate date) {
        return date.format(OUTPUT_FORMAT);
    }
}