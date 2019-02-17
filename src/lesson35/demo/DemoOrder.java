package lesson35.demo;


import lesson35.controller.OrderController;
import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.repository.RoomRepository;
import lesson35.repository.UserRepository;
import lesson35.service.Loaders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DemoOrder {
    public static void main(String[] args) throws Exception {

        Loaders.loadUserArrayList();
        Loaders.loadMapObjectId();
        Loaders.loadHotelsArrayList();
        Loaders.loadRoomsArrayList();
        Loaders.loadOrderArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD-MM-YYYY");

        User user  = UserRepository.getUserFromFileById(240);
        Hotel hotel = new Hotel("Ukraine", "Ternopil", "Bandery");
        Room room = new Room(2, 200, true, true,simpleDateFormat.parse("01-01-2019"), hotel);


        Order order1 = new Order(user, room, simpleDateFormat.parse("02-01-2000"), simpleDateFormat.parse("02-01-2000"), 50);
        Order order2 = new Order(user, room, simpleDateFormat.parse("14-01-2000"),simpleDateFormat.parse("15-01-2000"), 100);

        OrderController orderController = new OrderController();

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
