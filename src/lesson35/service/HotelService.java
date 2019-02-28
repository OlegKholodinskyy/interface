package lesson35.service;

import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

import java.io.IOException;
import java.util.ArrayList;

public class HotelService {
    HotelRepository hotelRepository = new HotelRepository();

    public Hotel addHotel(Hotel hotel) throws BadInputException, IOException, BadRequestException {
        validationBeforeAddingHotel(hotel);
        checkIfHotelIsAlreadyPresent(hotel);
        return hotelRepository.addHotel(hotel);
    }

    private void checkIfHotelIsAlreadyPresent(Hotel hotel) throws IOException, BadRequestException {
        ArrayList<Hotel> hotels = hotelRepository.buildArrayListOfHotels();
        for (Hotel h : hotels) {
            if (h.equals(hotel))
                throw new BadRequestException("Hotel with name " + hotel.getName() + " and city " + hotel.getCity() + " is present in base");
        }
    }

    private void validationBeforeAddingHotel(Hotel hotel) throws BadInputException {
        if (hotel.getName() == null || hotel.getStreet() == null || hotel.getCity() == null || hotel.getCountry() == null)
            throw new BadInputException("All fields must be filled. Hotel not added");
    }

    public Long dellteHotel(long hotelId) throws IOException, BadRequestException {
        checkIfHotelWithNecessaryIdIsPresent(hotelId);
        return  hotelRepository.deleteHotel(hotelId);

    }

    private void checkIfHotelWithNecessaryIdIsPresent(long hotelId) throws IOException, BadRequestException {
        ArrayList<Hotel> hotels = hotelRepository.buildArrayListOfHotels();
        for (Hotel h : hotels) {
            if (h.getId() == hotelId) {
                return;
            }
        }
        throw new BadRequestException("Hotel with id " + hotelId + " not found in the file");
    }

    public Hotel getHotelById(long idHotel) throws IOException, BadRequestException {
        return hotelRepository.getHotelById(idHotel);
    }

    public Hotel findHotelByName(String name) throws IOException, BadRequestException {
        return hotelRepository.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String name) throws IOException, BadRequestException {
        return hotelRepository.findHotelByCity(name);
    }
}
