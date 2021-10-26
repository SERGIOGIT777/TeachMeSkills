package DZ12;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Application5 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1988, 7, 10);
        LocalDate datenow = LocalDate.now();
        var id =date.until(datenow, ChronoUnit.DAYS);
        System.out.println(id);
    }
}
