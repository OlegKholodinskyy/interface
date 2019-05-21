package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.exception.BadRequestException;
import lesson35.controller.UserController;
import lesson35.exception.BadInputException;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.model.UserType;
import lesson35.repository.UserRepository;
import lesson35.service.Loaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoUser {
    public static void main(String[] args) {

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
        HotelController hotelController = new HotelController();
        UserController userController = new UserController();

        try {
            userController.login("Oleg","1234");
        } catch (BadRequestException e) {
            e.printStackTrace();
        } catch (BadInputException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            userController.deleteUser(1808);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
/*
        User userFirst = new User("Ol111eg", "1234", "Ukraine", UserType.ADMIN);
        User userSecond = new User("St222epan", "1234", "Ukraine", UserType.USER);
        User userThird = new User("333322", "1234", "Ukraine", UserType.ADMIN);
        User userFourth = new User("Irina", "1234", "Germany", UserType.USER);
        User userFifth = new User("Olga", "1234", "USA", UserType.USER);




        try {
            userController.registerUser(userFirst);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            userController.registerUser(userSecond);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            userController.registerUser(userThird);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            userController.registerUser(userFourth);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            userController.registerUser(userFifth);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            User user = userController.login("Oleg", "1234");
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Hotel hotel = new Hotel("34523", "USA", "Vashington", "Rusveld str.");
        Hotel hotel2 = new Hotel("Toront54oTest", "CANADA", "torinto", "Lvovska str.");
        Hotel hotel3 = new Hotel("534534534", "Poland", "Varshava", "Main str.");
        try {
            userController.addHotel(hotel);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            userController.addHotel(hotel2);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }

        try {
            userController.addHotel(hotel3);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }
        try {
            userController.deleteHotel(54);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println( hotelController.getHotelById(3473));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            userController.logout("Oleg");
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            e.printStackTrace();
        }

        try {
            Date dateAviableFrom = null;
            dateAviableFrom = simpleDate.parse("02-05-2019");
            Room room1 = new Room(4, 400, true, true, dateAviableFrom, hotelController.getHotelById(121));
            userController.addRoom(room1);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            userController.deleteRoom(1060);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(userController.findHotelByName("Toronto"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(userController.findHotelByCity("Toronto"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }
*/
        try {
        Date dateFrom = simpleDate.parse("01-03-2022");
        Date dateTo = simpleDate.parse("03-03-2022");
        userController.bookRoom(1058, 240, 201, dateFrom,dateTo,50);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }
/*

        try {
            Date dateFrom = simpleDate.parse("04-03-2019");
            Date dateTo = simpleDate.parse("05-03-2019");
            userController.bookRoom(1058, 289, 201, dateFrom,dateTo,150);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }

        try {
            Date dateFrom = simpleDate.parse("06-03-2019");
            Date dateTo = simpleDate.parse("09-03-2019");
            userController.bookRoom(1079, 1034, 201, dateFrom,dateTo,150);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }

        try {
            Date dateFrom = simpleDate.parse("24-06-2017");
            Date dateTo = simpleDate.parse("26-06-2017");
            userController.bookRoom(1058, 240, 201, dateFrom,dateTo,10);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }


        try {
            userController.cancelReservation(1058,289);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (BadRequestException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/


    }
}