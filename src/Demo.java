import java.time.LocalDate;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {

        Date now = new Date();
        LocalDate today = LocalDate.now();
        System.out.println(now);
        System.out.println(today);
    }
}
