package lesson35.model;

import lesson35.repository.PropertyRepository;
import lesson35.service.Loaders;

public class Hotel {
    private long id;
    private String country;
    private String city;
    private String street;

    public Hotel(long id, String country, String city, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Hotel(String country, String city, String street) {
        this(Loaders.getMapObjectIds().get("idHotel"),country,city,street);
        PropertyRepository.incrementIdsAndLoadToFile("idHotel");
    }

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}
