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

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoUser {
    public static void main(String[] args) {

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
        HotelController hotelController = new HotelController();

        User userFirst = new User("Oleg", "1234", "Ukraine", UserType.ADMIN);
        User userSecond = new User("Stepan", "1234", "Ukraine", UserType.USER);
        User userThird = new User("Oleguner", "1234", "Ukraine", UserType.ADMIN);
        User userFourth = new User("Irina", "1234", "Germany", UserType.USER);
        User userFifth = new User("Olga", "1234", "USA", UserType.USER);


        UserController userController = new UserController();

        try {
            userController.registerUser(userFirst);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }
        try {
            userController.registerUser(userSecond);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }
        try {
            userController.registerUser(userThird);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            userController.registerUser(userFourth);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            userController.registerUser(userFifth);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user = userController.login("Oleg", "1234");
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }


        Hotel hotel = new Hotel("RockHotel", "USA", "Vashington", "Rusveld str.");
        Hotel hotel2 = new Hotel("Toronto", "CANADA", "torinto", "Lvovska str.");
        Hotel hotel3 = new Hotel("VarshavaMainHotel", "Poland", "Varshava", "Main str.");
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
            userController.deleteHotel(81);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

/*
        try {
            userController.logout("Oleg");
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            e.printStackTrace();
        }
*/
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

        try {
        Date dateFrom = simpleDate.parse("10-06-2016");
        Date dateTo = simpleDate.parse("16-06-2016");
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



        try {
            Date dateFrom = simpleDate.parse("15-06-2017");
            Date dateTo = simpleDate.parse("17-06-2017");
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
            Date dateFrom = simpleDate.parse("17-06-2017");
            Date dateTo = simpleDate.parse("17-06-2017");
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
    }




}