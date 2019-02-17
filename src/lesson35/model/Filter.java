package lesson35.model;

import java.util.Date;

public class Filter {

    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAviableFrom;
    private String country;
    private String city;

    public Filter(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAviableFrom, String country, String city) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAviableFrom = dateAviableFrom;
        this.country = country;
        this.city = city;
    }
}
