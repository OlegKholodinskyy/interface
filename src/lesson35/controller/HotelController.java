package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

public class HotelController {
    HotelService hotelService = new HotelService();

    public Hotel addHotel(Hotel hotel){
        return hotelService.addHotel(hotel);
    }

}
