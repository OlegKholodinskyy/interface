package lesson35.repository;

import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import java.io.*;
import java.util.ArrayList;

public class HotelRepository {
    ArrayList<Hotel> hotelArrayList = new ArrayList<>();
    File file = new File("c:\\java\\hotel.txt");


    public Hotel addHotel(Hotel hotel) throws BadRequestException, IOException {
        validation(file);
        String hotelInString = hotel.getId() + ", " +
                hotel.getName() + ", " +
                hotel.getCountry() + ", " +
                hotel.getCity() + ", " +
                hotel.getStreet();
        RepositoryHelper.append(hotelInString, file);
        return hotel;
    }

    public ArrayList<Hotel> buildArrayListOfHotels() throws IOException, BadRequestException {
        validation(file);
        hotelArrayList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String hotelInString;
            while ((hotelInString = br.readLine()) != null) {
                hotelArrayList.add(buildHotel(hotelInString));
            }
        }
        return hotelArrayList;
    }

    public static Hotel buildHotel(String hotelInString) {

        String[] hotelInStringArray = hotelInString.trim().split(", ");
        Long id = Long.parseLong(hotelInStringArray[0]);
        String name = hotelInStringArray[1];
        String country = hotelInStringArray[2];
        String city = hotelInStringArray[3];
        String street = hotelInStringArray[4];
        return new Hotel(id, name, country, city, street);
    }

    public long deleteHotel(long hotelId) throws BadRequestException, IOException {
        validation(file);
        StringBuffer buffer = RepositoryHelper.excludeRequired(hotelId, file);
        RepositoryHelper.writeToFile(buffer, file);
        System.out.println("Hotel with id " + hotelId + " is deleted");
        return hotelId;
    }

    public Hotel getHotelById(long idHotel) throws IOException, BadRequestException {

        String hotelInString = RepositoryHelper.getStringById(idHotel, file);

        if (hotelInString != null) {
            return buildHotel(hotelInString);
        }
        throw new BadRequestException("Hotel  with id : " + idHotel + "  not found in base.");
    }

    public   Hotel findHotelByName(String name) throws IOException, BadRequestException {
        ArrayList<Hotel> hotels = buildArrayListOfHotels();
        for (Hotel h : hotels) {
            if (h.getName().equals(name)) {
                return h;
            }
        }
        throw new BadRequestException("Hotel  with name : " + name + "  not found in base.");
    }

    public ArrayList<Hotel> findHotelByCity(String name) throws IOException, BadRequestException {
        ArrayList<Hotel> hotels = buildArrayListOfHotels();
        ArrayList<Hotel> hotelsFromCity = new ArrayList<>();
        for (Hotel h : hotels) {
            if (h.getCity().equals(name)) {
                hotelsFromCity.add(h);
            }
        }
        if (hotelsFromCity.isEmpty()) {
            throw new BadRequestException("There are no hotels  in city : " + name);
        }
        return hotelsFromCity;
    }

    private static void validation(File file) throws BadRequestException, FileNotFoundException {

        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.toString() + " does not exist");
        }
        if (!file.canRead()) {
            throw new BadRequestException("File " + file.toString() + " does not have permission to read");
        }
        if (!file.canWrite()) {
            throw new BadRequestException("File " + file.canRead() + " does not have permission to write");
        }
    }
}
