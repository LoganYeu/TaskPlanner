import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Scanner;

public class Time {

    public Time() {

    }

    public static LocalTime getLocalTime() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String text = now.format(formatter);
        LocalTime parsedTime = LocalTime.parse(text, formatter);

        return parsedTime;
    }


}
