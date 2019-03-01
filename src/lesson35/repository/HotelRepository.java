package lesson35.repository;

import lesson35.exception.BadInputException;
import lesson35.exception.BadParseException;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import java.io.*;
import java.util.ArrayList;

public class HotelRepository {
    ArrayList<Hotel> hotelArrayList = new ArrayList<>();
    File file = new File("c:\\java\\hotel.txt");


    public Hotel addHotel(Hotel hotel) throws BadRequestException {
        validation(file);

        String hotelInStringPresentation = hotel.getId() + ", " +
                hotel.getName() + ", " +
                hotel.getCountry() + ", " +
                hotel.getCity() + ", " +
                hotel.getStreet();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(hotelInStringPresentation + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return hotel;
    }

    public ArrayList<Hotel> buildArrayListOfHotels() throws FileNotFoundException, IOException, BadRequestException {
        validation(file);
        hotelArrayList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String hotelInStringPresentation;
            while ((hotelInStringPresentation = br.readLine()) != null) {
                hotelArrayList.add(buildHotel(hotelInStringPresentation));
            }
        }
        return hotelArrayList;
    }

    public static Hotel buildHotel(String hotelInStringPresentation) {
        Hotel hotel;
        String[] hotelInStringPresentationArray = hotelInStringPresentation.trim().split(", ");


        Long id = Long.parseLong(hotelInStringPresentationArray[0]);
        String name = hotelInStringPresentationArray[1];
        String country = hotelInStringPresentationArray[2];
        String city = hotelInStringPresentationArray[3];
        String street = hotelInStringPresentationArray[4];
        return hotel = new Hotel(id, name, country, city, street);


    }

    public long deleteHotel(long hotelId) throws BadRequestException {
        validation(file);
        StringBuffer buffer = loadFileToStringBufferExceptHotelWithNecessaryId(hotelId);
        writeHotelstoFile(buffer);
        System.out.println("Hotel with id " + hotelId + " is deleted");
        return hotelId;
    }

    private void writeHotelstoFile(StringBuffer buffer) throws BadRequestException {
        validation(file);
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            br.append(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private StringBuffer loadFileToStringBufferExceptHotelWithNecessaryId(long hotelId) {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String hotelInString;
            while ((hotelInString = bufferedReader.readLine()) != null) {
                String hotelInArr[] = hotelInString.split(", ");
                if (Long.parseLong(hotelInArr[0]) != hotelId) {
                    stringBuffer.append(hotelInString + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return stringBuffer;
    }


    private static void validation(File file) throws BadRequestException {

        if (!file.exists()) {
            throw new BadRequestException("File " + file.toString() + " does not exist");
        }
        if (!file.canRead()) {
            throw new BadRequestException("File " + file.toString() + " does not have permission to read");
        }
        if (!file.canWrite()) {
            throw new BadRequestException("File " + file.canRead() + " does not have permission to write");
        }
    }

    public Hotel getHotelById(long idHotel) throws IOException, BadRequestException {
        ArrayList<Hotel> hotels = buildArrayListOfHotels();
        for (Hotel h : hotels){
            if (h.getId() == idHotel){
                return h;
            }
        }
        throw new BadRequestException("Hotel  with id : " + idHotel + "  not found in base.");
    }

    public Hotel findHotelByName(String name) throws IOException, BadRequestException {
        ArrayList<Hotel> hotels = buildArrayListOfHotels();
        for (Hotel h : hotels){
            if (h.getName().equals(name)){
                return h;
            }
        }
        throw new BadRequestException("Hotel  with name : " + name + "  not found in base.");
    }

    public ArrayList<Hotel> findHotelByCity(String name) throws IOException, BadRequestException {
        ArrayList<Hotel> hotels = buildArrayListOfHotels();
        ArrayList<Hotel> hotelsFromCity = new ArrayList<>();
        for (Hotel h : hotels){
            if (h.getCity().equals(name)){
                hotelsFromCity.add(h);
            }
        }
        if (hotelsFromCity.isEmpty()){
        throw new BadRequestException("There are no hotels  in city : " + name);}
        return hotelsFromCity;
     }
}
