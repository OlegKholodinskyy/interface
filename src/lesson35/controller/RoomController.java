package lesson35.controller;

import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Room;
import lesson35.service.RoomService;

import java.io.IOException;

public class RoomController {

    RoomService roomService=new RoomService() ;

    public  Room addRoom(Room room) throws BadRequestException, BadInputException, IOException {
        return roomService.addRoom(room);
    }

    public long deleteRoom(long roomId) throws BadRequestException, IOException {
        return roomService.deleteRoomdRoom(roomId);
    }
}
