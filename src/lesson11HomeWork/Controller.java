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

        Set<Room> setRooms = new HashSet();
        for (API api : apis) {
            Room[] rooms = api.findRooms(price, persons, city, hotel);
            for (Room room : rooms) {
                setRooms.add(room);
            }
        }
        Room[] rooms = new Room[setRooms.size()];
        return setRooms.toArray(rooms);
    }

    public Room[] check(API api1, API api2) {
        ArrayList<Room> resultRoomList = new ArrayList<>();
        Room[] resRoomAPI1 = api1.getAll();
        Room[] resRoomAPI2 = api2.getAll();

        int index= 0;
        for (int i = 0; i<resRoomAPI1.length; i++){
            for (int j =0; j<resRoomAPI2.length; j++){
                if (resRoomAPI1[j].equals(resRoomAPI2[i]) &&  !resultRoomList.contains(resRoomAPI1[j])){
                    resultRoomList.add(resRoomAPI1[j]);
                }
            }
        }

        Room[] resultArray = new Room[resultRoomList.size()];
        return resultRoomList.toArray(resultArray);
    }
}
