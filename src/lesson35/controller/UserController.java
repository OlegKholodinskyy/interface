package lesson35.controller;

import lesson35.exception.BadRequestException;
import lesson35.exception.BadInputException;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.service.HotelService;
import lesson35.service.RoomService;
import lesson35.service.UserService;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class UserController {
    private UserService userService = new UserService();
    private HotelService hotelService = new HotelService();
    private RoomService roomService = new RoomService();

    public User registerUser(User user) throws BadInputException, BadRequestException {
        return userService.registerUser(user);
    }

    public User login(String userName, String pass) throws BadRequestException, BadInputException {
        return userService.login(userName, pass);
    }

    public User logout(String userName) throws BadInputException, BadRequestException {
        return userService.logout(userName);
    }

    public Hotel addHotel(Hotel hotel) throws BadRequestException, IOException, BadInputException {
        return userService.addHotel(hotel);
    }

    public Long deleteHotel(long hotelId) throws BadRequestException, IOException {
        return userService.deleteHotel(hotelId);
    }

    public Room addRoom(Room room) throws BadRequestException, BadInputException {
        return userService.addRoom(room);
    }

    public long deleteRoom(long roomId) throws BadRequestException {
        return userService.deleteRoom(roomId);
    }

    public Hotel findHotelByName(String name) throws IOException, BadRequestException {
        return hotelService.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String name) throws IOException, BadRequestException {
        return hotelService.findHotelByCity(name);
    }

    public void bookRoom(long roomId, long userId, long hotelId, Date dateFrom, Date dateTo, double moneyPaid) throws BadRequestException, BadInputException, ParseException, IOException {
        roomService.bookRoom(roomId, userId, hotelId, dateFrom,dateTo,moneyPaid);
    }


    public void cancelReservation(long roomId, long userId) throws ParseException, BadRequestException, IOException {
        roomService.cancelReservation (roomId,userId);
    }

}
