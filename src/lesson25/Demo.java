package lesson25;

import lesson25.exception.BadRequestException;
import lesson25.exception.InternalServerException;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Car> carDAO = GeneralDAO.create(Car.class);
        try {
            System.out.println(carDAO.save(new Car()).toString());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
       }catch (InternalServerException e) {
            System.out.println(e.getMessage());
        }

        GeneralDAO<Book> bookDAO = new GeneralDAO<>(Book.class);
        try {
            System.out.println(bookDAO.save(new Book()).toString());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }catch (InternalServerException e) {
            System.out.println(e.getMessage());
        }
        GeneralDAO<Book> bookDAO2 = new GeneralDAO<>(Book.class);
        try {
            System.out.println(bookDAO2.save(new Book()).toString());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (InternalServerException e) {
            System.out.println(e.getMessage());
        }
    }
}
