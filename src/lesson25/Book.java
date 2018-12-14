package lesson25;

public class Book extends HelperId {

    long id;
    static int i = 0;

    Book() {
        this.id = i;
        i++;
    }

    @Override
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
