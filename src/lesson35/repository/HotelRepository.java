package lesson35.repository;

import lesson35.exception.BadInputException;
import lesson35.exception.BadParseException;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import java.io.*;
import java.util.ArrayList;

public class HotelRepository {
    static ArrayList<Hotel> hotelArrayList = new ArrayList<>();


    public Hotel saveHotelToFile(Hotel hotel) {
        String hotelInStringPresentation = hotel.getId() + ", " + hotel.getCountry() + ", " + hotel.getCity() + ", " + hotel.getStreet();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\java\\hotel.txt", true))) {
            bufferedWriter.append(hotelInStringPresentation + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return hotel;
    }

    public static ArrayList<Hotel> buildArrayListOfHotels() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\java\\hotel.txt"))) {
            String hotelInStringPresentation;
            while ((hotelInStringPresentation = br.readLine()) != null) {
                hotelArrayList.add(buildHotel(hotelInStringPresentation));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hotelArrayList;
    }

    public static Hotel buildHotel(String hotelInStringPresentation) throws Exception {
        Hotel hotel;
        String[] hotelInStringPresentationArray = hotelInStringPresentation.trim().split(", ");

        try {
            Long id = Long.parseLong(hotelInStringPresentationArray[0]);
            String country = hotelInStringPresentationArray[1];
            String city = hotelInStringPresentationArray[2];
            String street = hotelInStringPresentationArray[3];
            return hotel = new Hotel(id, country, city, street);
        }
        catch (Exception e){
            throw new Exception("bad in hotel.txt");
        }
    }

    public static Hotel getHotelById(long id) throws BadRequestException {

        for (Hotel h : hotelArrayList) {
            if (h.getId() == id) {
                return h;
            }
        }
        throw new BadRequestException("Hotel with id " + id + "not found in base");
    }

}
