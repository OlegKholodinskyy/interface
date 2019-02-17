package lesson35.model;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import lesson35.repository.PropertyRepository;
import lesson35.service.Loaders;

import java.util.Date;

public class Room {
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAviableFrom;
    private Hotel hotel;

    public Room(long id, int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAviableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAviableFrom = dateAviableFrom;
        this.hotel = hotel;
    }

    public Room(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAviableFrom, Hotel hotel) {
        this(Loaders.getMapObjectIds().get("idRoom"), numberOfGuests, price, breakfastIncluded, petsAllowed, dateAviableFrom, hotel);
        PropertyRepository.incrementIdsAndLoadToFile("idRoom");
    }

    public long getId() {
        return id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAviableFrom() {
        return dateAviableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
