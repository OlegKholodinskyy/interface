package lesson11HomeWork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controller {
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {

        ArrayList<Room> listRooms = new ArrayList<>();
        for (API api : apis) {
            Room[] rooms = api.findRooms(price, persons, city, hotel);
            for (Room room : rooms) {
                listRooms.add(room);
            }
        }
        Room[] rooms = new Room[listRooms.size()];
        return listRooms.toArray(rooms);
    }

    public Room[] check(API api1, API api2) {
        ArrayList<Room> resultRoomList = new ArrayList<>();
        Room[] resRoomAPI1 = api1.getAll();
        Room[] resRoomAPI2 = api2.getAll();

        int index= 0;
        for (Room room1 : resRoomAPI1){
            for (Room room2 : resRoomAPI2){
                if (room1.equals(room2) &&  !resultRoomList.contains(room1)){
                    resultRoomList.add(room1);
                }
            }
        }

        Room[] resultArray = new Room[resultRoomList.size()];
        return resultRoomList.toArray(resultArray);
    }
}
