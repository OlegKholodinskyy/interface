package lesson27.hw2;

import java.util.ArrayList;

public class Controller {
    public static void delete(long id) throws IllegalArgumentException {
        UserRepository.delete(id);
    }

    public static void delete(User user) throws IllegalArgumentException {
        UserRepository.delete(user);
    }

    public static User update(User user) throws IllegalArgumentException {
        return UserRepository.update(user);
    }

    public static User save(User user) {
        return UserRepository.save(user);
    }

    public static User getUserById(Long id) {
        return UserRepository.getUserById(id);
    }

    public static User getUserByName(String name) {
        return UserRepository.getUserByName(name);
    }

    public static User getUserBySessionId(String sessionId) {
        return UserRepository.getUserBySessionId(sessionId);
    }

    public static String getUserNameById(Long id) {
        return UserRepository.getUserNameById(id);
    }

    public static ArrayList<String> getUserNames() {
        return UserRepository.getUserNames();
    }

    public static ArrayList<Long> getUserIds() {
        return UserRepository.getUserIds();
    }

    public static ArrayList<User> getUsers(){
        return UserRepository.getUsers();
    }
}
