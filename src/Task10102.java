import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/*
Buon Compleanno!
*/

public class Task10102 {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
        System.out.println(getWeekdayOfBirthday("1.12.2015", "2016"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate date = LocalDate.parse(birthday, dtf).withYear(Year.parse(year).getValue());
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}
