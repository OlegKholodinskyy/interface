package lesson35.repository;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RoomRepository {
    private static ArrayList<Room> roomsArrayList;

    public static Room getRoomFromFileById(long id) throws BadRequestException {
        if (roomsArrayList != null) {
            for (Room r : roomsArrayList) {
                if (r.getId() == id) {
                    return r;
                }
            }
        }
        throw new BadRequestException("Room with id " + id + "not found in base");
    }

    public static ArrayList<Room> buildArrayListOfRooms() throws BadRequestException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\java\\room.txt"))) {
            String roomInStringPresentation;
            while ((roomInStringPresentation = br.readLine()) != null) {
                roomsArrayList.add(buildRoom(roomInStringPresentation));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomsArrayList;
    }

    private static Room buildRoom(String roomInStringPresentation) throws BadRequestException {
        Room room;
        String[] roomInStringPresentationArray = roomInStringPresentation.trim().split(", ");

        try {
            long id = Long.parseLong(roomInStringPresentationArray[0]);
            int numberOfGuests = Integer.parseInt(roomInStringPresentationArray[1]);
            double price = Double.parseDouble(roomInStringPresentationArray[2]);
            Boolean breakfastIncluded = Boolean.valueOf(roomInStringPresentationArray[3]);
            Boolean petsAllowed = Boolean.valueOf(roomInStringPresentationArray[4]);
            Date dateAviable = new SimpleDateFormat("DD-MM-YYYY").parse(roomInStringPresentationArray[5]);
            Hotel hotel = HotelRepository.getHotelById(Integer.parseInt(roomInStringPresentationArray[6]));
            return room = new Room(id, numberOfGuests, price, breakfastIncluded, petsAllowed, dateAviable, hotel);
        } catch (BadRequestException e) {
            throw new BadRequestException("bad in room.txt");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public Room addRoomToFile(Room room) {

        String roomInStringPresentation = room.getId() + ", " + room.getNumberOfGuests() + ", " +
                room.getPrice() + ", " + room.isBreakfastIncluded() + ", " + room.isPetsAllowed() + ", " +
                new SimpleDateFormat("DD-MM-YYYY").format(room.getDateAviableFrom()) + ", " + room.getHotel();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\room.txt", true))) {
            bufferedWriter.append(roomInStringPresentation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return room;
    }
}
