package lesson35.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
        Date dateFrom = simpleDate.parse("2018-09-09");
        System.out.println(simpleDate.format(dateFrom));

    }
}
