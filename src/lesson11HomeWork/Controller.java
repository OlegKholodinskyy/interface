package lesson11HomeWork;

import java.util.HashSet;
import java.util.Set;

public class Controller {
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel){

        Set<Room> setRooms = new HashSet();
        for (API api : apis){
           Room[] rooms = api.findRooms( price,  persons, city, hotel);
           for (Room room : rooms ){
               setRooms.add(room);
           }
        }
        Room[] rooms = new Room[setRooms.size()];
        return setRooms.toArray(rooms);
    }
}
