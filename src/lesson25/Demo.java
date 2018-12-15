package lesson25;

import lesson25.exception.BadRequestException;
import lesson25.exception.InternalServerException;

public class Demo {
    public static void main(String[] args) {
        //GeneralDAO<Car> carDAO = GeneralDAO.create(Car.class);
      //  GeneralDAO<Book> generalDAO = new GeneralDAO();

     //   try {
          //  System.out.println(carDAO.save(new Car()).toString());
     //   } catch (BadRequestException e) {
     //       System.out.println(e.getMessage());
     //  }catch (InternalServerException e) {
      //      System.out.println(e.getMessage());
      //  }

        //GeneralDAO<Book> bookDAO = new GeneralDAO<>();

        GeneralDAO<Book> systemDAO = new GeneralDAO<>();
        Book system1 = new Book();

        try {
            systemDAO.save(system1);
        } catch (BadRequestException e) {
            e.printStackTrace();
        } catch (InternalServerException e) {
            e.printStackTrace();
        }


     //   try {
     //       System.out.println(bookDAO.save(new Book()).toString());
     //   } catch (BadRequestException e) {
     //       System.out.println(e.getMessage());
     //   }catch (InternalServerException e) {
     //       System.out.println(e.getMessage());
    //    }
        GeneralDAO<Book> bookDAO2 = new GeneralDAO<>();
        try {
            System.out.println(bookDAO2.save(new Book()).toString());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (InternalServerException e) {
            System.out.println(e.getMessage());
        }
    }
}
