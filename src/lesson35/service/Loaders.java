package lesson35.service;

import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.repository.HotelRepository;
import lesson35.repository.OrderRepository;
import lesson35.repository.RoomRepository;
import lesson35.repository.UserRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Loaders {

    private static ArrayList<User> usersArrayList;
    private static ArrayList<Order> ordersArrayList;
    private static ArrayList<Room> roomsArrayList;
    private static ArrayList<Hotel> hotelsArrayList;
    private static Map<String, Long> mapObjectIds;



    public static void loadUserArrayList() {
        if (usersArrayList == null) {
            usersArrayList = new ArrayList<User>();
        } else {
            usersArrayList.clear();
        }
        usersArrayList = UserRepository.buildArrayListOfUsers();
    }

    public static ArrayList<User> getUsersArrayList() {
        return usersArrayList;
    }

    public static ArrayList<Room> getRoomsArrayList() {
        return roomsArrayList;
    }

    public static ArrayList<Hotel> getHotelsArrayList(){
        return hotelsArrayList;
    }
    public static void loadOrderArrayList() throws BadRequestException {
        if (ordersArrayList == null) {
            ordersArrayList = new ArrayList<Order>();
        } else {
            ordersArrayList.clear();
        }
        ordersArrayList = OrderRepository.buildArrayListOfOrders();
    }

    public static ArrayList<Order> getOrdersArrayList() {
        return ordersArrayList;
    }

    public static void loadMapObjectId() {

        if (mapObjectIds == null) {
            mapObjectIds = new HashMap<String, Long>();
            mapObjectIds.put("idUser", 1000L);
            mapObjectIds.put("idOrder", 1000L);
            mapObjectIds.put("idRoom", 1000L);
            mapObjectIds.put("idRoom", 1000L);
        }


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\java\\settings.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.trim().split(":");

                if (arr[0] != null && arr[0].equals("idUser")) {
                    mapObjectIds.put("idUser", Long.parseLong(arr[1]));
                }
                if (arr[0] != null && arr[0].equals("idOrder")) {
                    mapObjectIds.put("idOrder", Long.parseLong(arr[1]));
                }
                if (arr[0] != null && arr[0].equals("idRoom")) {
                    mapObjectIds.put("idRoom", Long.parseLong(arr[1]));
                }
                if (arr[0] != null && arr[0].equals("idHotel")) {
                    mapObjectIds.put("idHotel", Long.parseLong(arr[1]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Long> getMapObjectIds() {
        if (mapObjectIds == null || mapObjectIds.size() == 0) {
            loadMapObjectId();
        }
        return mapObjectIds;
    }

    public static ArrayList<Room> loadRoomsArrayList() throws BadRequestException {
        if (roomsArrayList == null) {
            roomsArrayList = new ArrayList<Room>();
        } else {
            roomsArrayList.clear();
        }
        roomsArrayList = RoomRepository.buildArrayListOfRooms();
        return roomsArrayList;
    }

    public static ArrayList<Hotel> loadHotelsArrayList() throws Exception {
        if (hotelsArrayList == null) {
            hotelsArrayList = new ArrayList<Hotel>();
        } else {
            hotelsArrayList.clear();
        }
        hotelsArrayList = HotelRepository.buildArrayListOfHotels();
        return hotelsArrayList;
    }
}
