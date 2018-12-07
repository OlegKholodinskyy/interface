package lesson11.lesson11HomeWork;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room room1 = new Room(1, 200, 2, new Date(01 / 01 / 2018), "Ukraina", "Ternopil");
        Room room2 = new Room(2, 300, 2, new Date(01 / 01 / 2018), "Ukraina", "Ternopil");
        Room room3 = new Room(3, 400, 4, new Date(01 / 01 / 2018), "Ukraina", "Kiev");
        Room room4 = new Room(4, 500, 2, new Date(01 / 01 / 2018), "Team", "Ternopil");
        Room room5 = new Room(5, 600, 6, new Date(01 / 01 / 2018), "Ukraina", "Dnipro");
        Room room6 = new Room(6, 700, 2, new Date(01 / 01 / 2018), "Ukraina", "Ternopil");

        Room[] rooms = new Room[]{room1, room2, room3, room4, room5, room6};

        API apiBookingComAPI = new BookingComAPI(new Room[]{room1, room2, room3, room4});
        API apiTripAdvisorAPI = new TripAdvisorAPI(new Room[]{room1, room5, room6});
        API apiGoogleAPI = new GoogleAPI(rooms);

        API[] apis = new API[]{apiBookingComAPI, apiGoogleAPI, apiTripAdvisorAPI};

        Controller controller = new Controller(apis);

        System.out.println("+++++++++ controller.requestRooms +++++++++++++++++");
        System.out.println();
        Room[] requestRooms = controller.requestRooms(600, 5, "Dnipro","Ukraina");

        for (Room room : requestRooms) {
            System.out.println(room);
        }

        System.out.println("+++++++++ controller.check +++++++++++++++++");
        System.out.println();
        Room[] checkRooms = controller.check(apiBookingComAPI,apiTripAdvisorAPI);

        for (Room room : checkRooms) {
            System.out.println(room);
        }


    }

}
