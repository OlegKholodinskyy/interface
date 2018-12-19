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

    public static User save(User user) throws IllegalArgumentException{
        return UserRepository.save(user);
    }

    public static User getUserById(Long id)throws IllegalArgumentException {
        return UserRepository.getUserById(id);
    }

    public static User getUserByName(String name) throws IllegalArgumentException{
        return UserRepository.getUserByName(name);
    }

    public static User getUserBySessionId(String sessionId) throws IllegalArgumentException{
        return UserRepository.getUserBySessionId(sessionId);
    }

    public static String getUserNameById(Long id) throws IllegalArgumentException {
        return UserRepository.getUserNameById(id);
    }

    public static ArrayList<String> getUserNames() throws IllegalArgumentException{
        return UserRepository.getUserNames();
    }

    public static ArrayList<Long> getUserIds() throws IllegalArgumentException{
        return UserRepository.getUserIds();
    }

    public static ArrayList<User> getUsers()throws IllegalArgumentException{
        return UserRepository.getUsers();
    }
}
