package lesson35.model;

import lesson35.repository.PropertyRepository;
import lesson35.service.Loaders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Order {

    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;


    public Order(long id, User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }
    public Order(User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this(Loaders.getMapObjectIds().get("idOrder"), user, room, dateFrom, dateTo, moneyPaid);
        PropertyRepository.incrementIdsAndLoadToFile("idOrder");

    }

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD-MM-YYYY");

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", moneyPaid=" + moneyPaid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(user, order.user) &&
                Objects.equals(room, order.room) &&
                Objects.equals(dateFrom, order.dateFrom) &&
                Objects.equals(dateTo, order.dateTo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, room, dateFrom, dateTo);
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }
}
