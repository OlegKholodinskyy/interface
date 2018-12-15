package lesson25;

public class Car {

    long id;
    static int i = 0;

    Car() {
        this.id = i;
        i++;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                '}';
    }
}


