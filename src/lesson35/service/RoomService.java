package lesson35.service;

import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.repository.ReservedMapRepository;
import lesson35.repository.RoomRepository;
import lesson35.repository.UserRepository;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class RoomService {

    RoomRepository roomRepository = new RoomRepository();
  //  OrderService orderService = new OrderService();
  //  UserRepository userRepository = new UserRepository();
  // ReservedMapRepository reservedMapRepository = new ReservedMapRepository();

    public Room addRoom(Room room) throws BadRequestException, BadInputException, IOException {
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

    public long deleteRoomdRoom(long roomId) throws BadRequestException, IOException {
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


    public void updateRoom(long id, Date dateTo) throws BadRequestException, IOException {
        Room room = getRoomById(id);
        roomRepository.deleteRoom(id);
        room.setDateAviableFrom(dateTo);
        roomRepository.addRoomToFile(room);
    }


    public Room getRoomById(long id) throws IOException, BadRequestException {
        return roomRepository.getRoomById(id);
    }
}
