package DataSaving;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExceptionCatching {

    public static LocalDate dateException(String date) {

        LocalDate dateNew = null;

        try {
            date = date.replaceAll("\\.", " ")
                    .replaceAll("-", " ")
                    .replaceAll("/", " ");


            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
            dateNew = LocalDate.parse(date, dtf);

        } catch (DateTimeException e) {
            dateNew = LocalDate.now();
        } catch (Exception e) {
            dateNew = LocalDate.now();
        }
        return dateNew;
    }
}
