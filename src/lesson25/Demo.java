package lesson25;

import lesson25.exception.BadRequestException;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Car> carDAO = new GeneralDAO<>();
        try {
            System.out.println(carDAO.save(new Car()).toString());
        } catch (BadRequestException e) {
            e.getMessage();
        }

        GeneralDAO<Book> bookDAO = new GeneralDAO<>();
        try {
            System.out.println(bookDAO.save(new Book()).toString());
        } catch (BadRequestException e) {
            e.getMessage();
        }

        GeneralDAO<Book> bookDAO2 = new GeneralDAO<>();
        try {
            System.out.println(bookDAO2.save(new Book()).toString());
        } catch (BadRequestException e) {
            e.getMessage();
        }

    }


}
