package lesson35.demo;

import lesson35.controller.RoomController;
import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.service.RoomService;

import java.beans.SimpleBeanInfo;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DemoRoom {
    public static void main(String[] args) throws ParseException, BadRequestException, BadInputException, IOException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
Hotel hotel= new Hotel("AAA","ukr","tern","fevevee");
        Room room = new Room(2,100,true,true, simpleDate.parse("2018-09-09"), hotel);
        RoomController roomController = new RoomController();
        roomController.addRoom(room);
    }
}
