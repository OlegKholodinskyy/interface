package lesson24.first;
public class User {
private int age;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }

    public User(int age) {
        this.age = age;
    }
}
