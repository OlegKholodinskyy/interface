package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.mm.yyyy");


        try {
            controller.save(new Transaction(1, "Kiev", 10, "some description", TransactionType.INCOME, format.parse("01.12.2018")));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (InternalServerException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }


        try {
            controller.save(new Transaction(12, "Odessa", 20, "some description", TransactionType.INCOME, format.parse("01.12.2018")));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (InternalServerException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            controller.save(new Transaction(2, "Odessa", 20, "some description", TransactionType.INCOME, format.parse("01.12.2018")));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (InternalServerException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        try {
            controller.save(new Transaction(3, "Ternopil", 20, "some description", TransactionType.INCOME, format.parse("01.12.2018")));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (InternalServerException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }


        Transaction[] list = controller.transactionList();

        for (Transaction tr : list) {
            if (tr != null)
                System.out.println(tr);
        }
        System.out.println("=============================================");
        Transaction[] list2 = controller.transactionList("Odessa");

        for (Transaction tr : list2) {
            if (tr != null)
                System.out.println(tr);
        }

    }
}
