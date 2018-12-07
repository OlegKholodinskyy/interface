package lesson11.lesson11HomeWork;

import java.util.ArrayList;

public class TripAdvisorAPI implements API{
    Room[] rooms;

    public TripAdvisorAPI() {
    }

    public TripAdvisorAPI(Room[] rooms) {

        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        ArrayList<Room> resultSearch = new ArrayList<>();
        for (Room room : rooms){
            if (room!=null){
                if (room.getPrice() == price && checkPerson (room.getPersons(), persons) && room.getCityName().equals(city) && room.getHotelName().equals(hotel)){
                    resultSearch.add(room);
                }
            }
        }
        Room[] resultArray = new Room[resultSearch.size()];
        return resultSearch.toArray(resultArray);
    }
    private boolean checkPerson(int personRoom , int person) {
        if ((personRoom == person) || (person <= personRoom +1 && person >= personRoom -1))
            return true;
        else
            return false;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
