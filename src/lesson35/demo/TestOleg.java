package lesson35.demo;

import lesson22_controller_Dao.task2.Demo;
import lesson35.repository.ReservedMapRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class TestOleg {
    public static void main(String[] args) throws ParseException {
        ReservedMapRepository b = new ReservedMapRepository();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD-MM-yyyy");

        Date d1 = simpleDateFormat.parse("21-11-2011");
        Date d2 = simpleDateFormat.parse("02-12-2080");
        HashSet<Date> hsd = new HashSet<>();
        hsd.add(d1);
        hsd.add(d2);

        b.saveToFileDateReserves(100L,hsd);
        }
}