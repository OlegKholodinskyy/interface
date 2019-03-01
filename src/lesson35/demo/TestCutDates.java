package lesson35.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestCutDates {
    public static void main(String[] args) throws ParseException {
        TestCutDates testCutDates = new TestCutDates();

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);


        String s = "22-06-2017,23-06-2017,24-06-2017,25-06-2017,26-06-2017,27-06-2017,28-06-2017,29-06-2017,30-06-2017,";
        ArrayList<Date> d = new ArrayList<>();
        d.add(simpleDate.parse("23-06-2017"));
        d.add(simpleDate.parse("25-06-2017"));
        testCutDates.cutString(s, d);
    }

    private void cutString(String sb, ArrayList<Date> dates) {

        ArrayList<String> listOfDates = new ArrayList<String>(Arrays.asList(sb.split(",")));
        ArrayList<String> listOfDatesForCutting = new ArrayList<>();

        for (Date d : dates) {
            listOfDatesForCutting.add(new SimpleDateFormat("dd-MM-yyyy").format(d));
        }

        listOfDates.removeAll(listOfDatesForCutting);

        for (String ss : listOfDates) {
            System.out.println(ss);
        }
    }
    }
