package lesson35.service;

import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.repository.RoomRepository;
import lesson35.repository.UserRepository;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class RoomService {

    RoomRepository roomRepository = new RoomRepository();
    OrderService orderService = new OrderService();
    UserRepository userRepository = new UserRepository();

    public Room addRoom(Room room) throws BadRequestException, BadInputException {
        checkIfRoomIsExist(room);
        validateBeforeAddingRoom(room);
        return roomRepository.addRoomToFile(room);
    }

    private void checkIfRoomIsExist(Room room) throws BadRequestException {

        ArrayList<Room> allRooms = roomRepository.buildArrayListOfRooms();
        if (allRooms == null || allRooms.isEmpty()) {
            return;
        }
        for (Room r : allRooms) {
            if (r.equals(room)) {
                throw new BadRequestException("Room with same parameter  is already  present in base");
            }
        }
    }

    private void validateBeforeAddingRoom(Room room) throws BadInputException {
        if (room.getNumberOfGuests() == 0 || room.getPrice() == 0 || room.getHotel() == null ||
                room.getDateAviableFrom() == null) {
            throw new BadInputException("All fields should be filled. Room with id = " + room.getId());
        }
    }

    public long deleteRoomdRoom(long roomId) throws BadRequestException {
        checkIfRoomWithNecessaryIdIsPresent(roomId);
        return roomRepository.deleteRoom(roomId);

    }

    private void checkIfRoomWithNecessaryIdIsPresent(long roomId) throws BadRequestException {
        ArrayList<Room> rooms = roomRepository.buildArrayListOfRooms();
        for (Room h : rooms) {
            if (h.getId() == roomId) {
                return;
            }
        }
        throw new BadRequestException("Room with id " + roomId + " not found in the file");
    }

    public void bookRoom(long roomId, long userId, long hotelId, Date dateFrom, Date dateTo, double moneyPaid) throws BadRequestException, ParseException, BadInputException, IOException {

        Order order = new Order(userRepository.getUserById(userId), roomRepository.getRoomById(roomId), dateFrom, dateTo, moneyPaid);
        orderService.addOrder(order);

    }
}
