package lesson11.lesson11HomeWork;

import java.util.ArrayList;

public class BookingComAPI implements API {
    Room[] rooms;

    public BookingComAPI() {
    }

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        ArrayList<Room> resultSearch = new ArrayList<>();
        for (Room room : rooms){
            if (room!=null){
                if (checkPrice(room.getPrice(), price) && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)){
                    resultSearch.add(room);
                }
            }
        }
        Room[] resultArray = new Room[resultSearch.size()];
        return resultSearch.toArray(resultArray);
    }
    private boolean checkPrice(int priceRoom , int priceChecked) {
        if ((priceChecked == priceRoom) || (priceChecked <= priceRoom +100 && priceChecked >= priceRoom -100))
            return true;
        else
            return false;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
