package lesson35.service;

import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

public class HotelService {
    HotelRepository hotelRepository = new HotelRepository();
    public Hotel addHotel(Hotel hotel) {
        // logic

        return hotelRepository.saveHotelToFile(hotel);
    }
}
