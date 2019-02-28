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

    public ArrayList<Room> buildArrayListOfRooms() throws BadRequestException {
        if (roomsArrayList==null){
            roomsArrayList = new ArrayList<>();
        }else{
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
        Room room;
        String[] roomInStringPresentationArray = roomInStringPresentation.trim().split(", ");

        try {
            long id = Long.parseLong(roomInStringPresentationArray[0]);
            int numberOfGuests = Integer.parseInt(roomInStringPresentationArray[1]);
            double price = Double.parseDouble(roomInStringPresentationArray[2]);
            Boolean breakfastIncluded = Boolean.valueOf(roomInStringPresentationArray[3]);
            Boolean petsAllowed = Boolean.valueOf(roomInStringPresentationArray[4]);
            Date dateAviable = new SimpleDateFormat("dd-MM-yyyy").parse(roomInStringPresentationArray[5]);
            Hotel hotel = getHotelById(Integer.parseInt(roomInStringPresentationArray[6]), hotelRepository.buildArrayListOfHotels());

            return room = new Room(id, numberOfGuests, price, breakfastIncluded, petsAllowed, dateAviable, hotel);
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

    public Room addRoomToFile(Room room) throws BadRequestException {
        validation(fileRoom);
        String roomInStringPresentation = room.getId() + ", " +
                room.getNumberOfGuests() + ", " +
                room.getPrice() + ", " +
                room.isBreakfastIncluded() + ", " +
                room.isPetsAllowed() + ", " +
                new SimpleDateFormat("dd-MM-yyyy").format(room.getDateAviableFrom()) + ", " +
                room.getHotel().getId() + "\n";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileRoom, true))) {
            bufferedWriter.append(roomInStringPresentation);
            System.out.println("Room id : " + room.getId() + " is added." );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return room;
    }


    private  void validation(File file) throws BadRequestException {

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

    public long deleteRoom(long roomId) throws BadRequestException {
        validation(fileRoom);
        StringBuffer buffer = loadFileToStringBufferExceptRoomWithNecessaryId(roomId);
        writeRoomsToFile(buffer);
        System.out.println("Room with id " + roomId + " is deleted");
        return roomId;
    }

    private void writeRoomsToFile(StringBuffer buffer) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileRoom))) {
            br.append(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private StringBuffer loadFileToStringBufferExceptRoomWithNecessaryId(long roomId) {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRoom))) {
            String roomInString;
            while ((roomInString = bufferedReader.readLine()) != null) {
                String roomlInArr[] = roomInString.split(", ");
                if (Long.parseLong(roomlInArr[0]) != roomId) {
                    stringBuffer.append(roomInString + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return stringBuffer;
    }

    public Room getRoomById(long roomId) throws BadRequestException {
        ArrayList<Room> arrayListRooms = buildArrayListOfRooms();
        for (Room r: arrayListRooms){
            if (r.getId() == roomId){
                return r;
            }
        }
        throw new BadRequestException("Room wiht id: " + roomId + "not found in base");
    }
}
