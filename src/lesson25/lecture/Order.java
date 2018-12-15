package lesson25.lecture;

public class Order extends IdEntity {
    private long id;
    @Override
    public long gerId() {
        return id;
    }

    public Order(long id) {
        this.id = id;
    }
}
