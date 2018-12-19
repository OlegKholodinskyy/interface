package lesson27.hw2;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "Oleg", "Session1"));
        UserRepository userRepository = new UserRepository(users);

        try {
            userRepository.save(new User(2, "Nick", "Session2"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            userRepository.save(new User(3, "Ira", "Session3"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            userRepository.save(new User(2, "Nick", "Session2"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Controller.delete(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Controller.update(new User(2, "UpdatedNick", "UpdatedSession"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (String userNames : Controller.getUserNames())
            System.out.println(userNames.toString());

        for(User user : Controller.getUsers()){
            System.out.println(user.toString());
        }
    }
}
