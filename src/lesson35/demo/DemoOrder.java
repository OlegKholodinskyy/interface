package lesson35.demo;


import lesson35.controller.OrderController;
import lesson35.controller.RoomController;
import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.repository.HotelRepository;
import lesson35.repository.RoomRepository;
import lesson35.repository.UserRepository;
import lesson35.service.Loaders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DemoOrder {
    public static void main(String[] args) throws Exception {
        RoomController roomController = new RoomController();
        OrderController orderController = new OrderController();
        UserRepository userRepository = new UserRepository();

        Loaders.loadAllParameters();

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);

        User user = userRepository.getUserFromFileById(240);
        User user1 = userRepository.getUserFromFileById(1013);
      //  Hotel hotel = HotelRepository.getHotelById(1000);
       Room room = RoomRepository.getRoomFromFileById(1056);

        roomController.addRoom(room);
        Order order1 = new Order(user1, room, simpleDate.parse("2018-09-09"), simpleDate.parse("2018-09-09"), 20);
        Order order2 = new Order(user, room, simpleDate.parse("2018-09-09"), simpleDate.parse("2018-09-09"), 100);


        try {
            orderController.addOrder(order1);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }
        try {
            orderController.addOrder(order2);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }


    }
}
