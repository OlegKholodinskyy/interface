package lesson35.repository;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.service.Loaders;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RoomRepository {
    private static ArrayList<Room> roomsArrayList;
    private File fileRoom = new File("C:\\java\\room.txt");
    HotelRepository hotelRepository = new HotelRepository();

    public ArrayList<Room> buildArrayListOfRooms() throws BadRequestException {
        if (roomsArrayList == null) {
            roomsArrayList = new ArrayList<>();
        } else {
            roomsArrayList.clear();
        }
        validation(fileRoom);
        try (BufferedReader br = new BufferedReader(new FileReader(fileRoom))) {
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

    private Room buildRoom(String roomInStringPresentation) throws BadRequestException, IOException {
        String[] roomArrInString = roomInStringPresentation.trim().split(", ");
        try {
            long id = Long.parseLong(roomArrInString[0]);
            int numberOfGuests = Integer.parseInt(roomArrInString[1]);
            double price = Double.parseDouble(roomArrInString[2]);
            Boolean breakfastIncluded = Boolean.valueOf(roomArrInString[3]);
            Boolean petsAllowed = Boolean.valueOf(roomArrInString[4]);
            Date dateAviable = new SimpleDateFormat("dd-MM-yyyy").parse(roomArrInString[5]);
            Hotel hotel = getHotelById(Integer.parseInt(roomArrInString[6]), hotelRepository.buildArrayListOfHotels());

            return new Room(id, numberOfGuests, price, breakfastIncluded, petsAllowed, dateAviable, hotel);
        } catch (BadRequestException e) {
            throw new BadRequestException("bad data in file room.txt");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    private static Hotel getHotelById(long i, ArrayList<Hotel> hotelsArrayList) throws BadRequestException {
        for (Hotel h : hotelsArrayList) {
            if (i == h.getId()) {
                return h;
            }
        }
        throw new BadRequestException("Hotel with id : " + i + "not found. Exception in roomRepository");
    }

    public Room addRoomToFile(Room room) throws BadRequestException, IOException {
        validation(fileRoom);
        String roomInString = room.getId() + ", " +
                room.getNumberOfGuests() + ", " +
                room.getPrice() + ", " +
                room.isBreakfastIncluded() + ", " +
                room.isPetsAllowed() + ", " +
                new SimpleDateFormat("dd-MM-yyyy").format(room.getDateAviableFrom()) + ", " +
                room.getHotel().getId() + "\n";
        RepositoryHelper.append(roomInString, fileRoom);
        System.out.println("Room id : " + room.getId() + " is added.");
        return room;
    }


    private void validation(File file) throws BadRequestException {

        if (!file.exists()) {
            throw new BadRequestException("File " + file.toString() + " does not exist");
        }
        if (!file.canRead()) {
            throw new BadRequestException("File " + file.toString() + " does not have permission to read");
        }
        if (!file.canWrite()) {
            throw new BadRequestException("File " + file.canRead() + " does not have permission to write");
        }

    }

    public long deleteRoom(long roomId) throws BadRequestException, IOException {
        validation(fileRoom);
        StringBuffer buffer = RepositoryHelper.excludeRequired(roomId, fileRoom);
        RepositoryHelper.writeToFile(buffer, fileRoom);
        System.out.println("Room with id " + roomId + " is deleted");
        return roomId;
    }

    public Room getRoomById(long roomId) throws BadRequestException, IOException {
        String roomInString = RepositoryHelper.getStringById(roomId, fileRoom);

        if (roomInString != null) {
            return buildRoom(roomInString);
        }
        throw new BadRequestException("Room wiht id: " + roomId + "not found in base");
    }
}
