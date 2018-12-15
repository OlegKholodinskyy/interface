package lesson25;

public class Book {

    long id;
    static int i = 0;

    Book() {
        this.id = i;
        i++;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                '}';
    }


}
