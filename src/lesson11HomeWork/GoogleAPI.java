package lesson11HomeWork;

import java.util.ArrayList;

public class GoogleAPI implements API {

    Room[] rooms;

    public GoogleAPI() {
    }

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;

    }
    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        ArrayList<Room> resultSearch = new ArrayList<>();
        for (Room room : rooms){
            if (room!=null){
                if (room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)){
                    resultSearch.add(room);
                }
            }
        }
        Room[] resultArray = new Room[resultSearch.size()];
        return resultSearch.toArray(resultArray);
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
