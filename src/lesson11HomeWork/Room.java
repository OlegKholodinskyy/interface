package lesson11HomeWork;

import java.util.Date;

public class Room {
    private long id;
    private int price;
    private int persons;
    private Date dateAviableFrom;
    private String hotelName;
    private String cityName;

    public Room(long id, int price, int persons, Date dateAviableFrom, String hotelName, String cityName) {
        this.id = id;
        this.price = price;
        this.persons = persons;
        this.dateAviableFrom = dateAviableFrom;
        this.hotelName = hotelName;
        this.cityName = cityName;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getPersons() {
        return persons;
    }

    public Date getDateAviableFrom() {
        return dateAviableFrom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDateAviableFrom(Date dateAviableFrom) {
        this.dateAviableFrom = dateAviableFrom;
    }
}
