package lesson35.service;

import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.util.ArrayList;

public class RoomService {

    RoomRepository roomRepository = new RoomRepository();

    public Room addRoom(Room room) throws BadRequestException, BadInputException {
        checkIfRoomIsExist(room);
        validateBeforeAddingRoom(room);
        return roomRepository.addRoomToFile(room);
    }

    private void checkIfRoomIsExist(Room room) throws BadRequestException {

        ArrayList<Room> allRooms = Loaders.getRoomsArrayList();
        for (Room r : allRooms) {
            if (r.equals(room)) {
                throw new BadRequestException("Room with name: " + room.getId() + " is present in base");
            }
        }
    }

    private void validateBeforeAddingRoom(Room room) throws BadInputException {
        if (room.getNumberOfGuests() == 0 || room.getPrice() == 0 || room.getHotel() == null ||
                room.getDateAviableFrom() == null) {
            throw new BadInputException("All fields should be filled. Room with id = " + room.getId());
        }
    }
}
