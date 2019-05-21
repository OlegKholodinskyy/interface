package lesson35.controller;

import lesson35.exception.BadRequestException;
import lesson35.exception.BadInputException;
import lesson35.model.Hotel;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.repository.ReservedMapRepository;
import lesson35.service.HotelService;
import lesson35.service.OrderService;
import lesson35.service.RoomService;
import lesson35.service.UserService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class UserController {
    private UserService userService = new UserService();
    private HotelService hotelService = new HotelService();
    private RoomService roomService = new RoomService();
    private OrderService orderService = new OrderService();
    private ReservedMapRepository reservedMapRepository = new ReservedMapRepository();

    public User registerUser(User user) throws BadInputException, BadRequestException, IOException {
        return userService.registerUser(user);
    }

    public User login(String userName, String pass) throws BadRequestException, BadInputException, FileNotFoundException {
        return userService.login(userName, pass);
    }

    public User logout(String userName) throws BadInputException, BadRequestException, FileNotFoundException {
        return userService.logout(userName);
    }

    public Hotel addHotel(Hotel hotel) throws BadRequestException, IOException, BadInputException {
        return userService.addHotel(hotel);
    }

    public Long deleteHotel(long hotelId) throws BadRequestException, IOException {
        return userService.deleteHotel(hotelId);
    }

    public Room addRoom(Room room) throws BadRequestException, BadInputException, IOException {
        return userService.addRoom(room);
    }

    public long deleteRoom(long roomId) throws BadRequestException, IOException {
        return userService.deleteRoom(roomId);
    }

    public Hotel findHotelByName(String name) throws IOException, BadRequestException {
        return hotelService.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String name) throws IOException, BadRequestException {
        return hotelService.findHotelByCity(name);
    }


    public void bookRoom(long roomId, long userId, long hotelId, Date dateFrom, Date dateTo, double moneyPaid) throws BadRequestException, BadInputException, ParseException, IOException {

        Order order = new Order(userService.getUserById(userId), roomService.getRoomById(roomId), dateFrom, dateTo, moneyPaid);
        orderService.addOrder(order);
    }


    public void cancelReservation(long roomId, long userId) throws ParseException, BadRequestException, IOException {
        orderService.dellOrder(roomId, userId);
    }

    public long deleteUser(long userId) throws BadRequestException, IOException {
        return userService.deleteUser(userId);
    }

}
