package lesson35.controller;

import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.service.HotelService;

import java.io.IOException;

public class HotelController {
    HotelService hotelService = new HotelService();

    public Hotel addHotel(Hotel hotel) throws BadRequestException, BadInputException, IOException {
        return hotelService.addHotel(hotel);
    }

    public long deleteHotel(long hotelId) throws IOException, BadRequestException {
        return hotelService.dellteHotel(hotelId);
    }

    public Hotel getHotelById(long idHotel) throws IOException, BadRequestException {
        return hotelService.getHotelById(idHotel);
    }
}
