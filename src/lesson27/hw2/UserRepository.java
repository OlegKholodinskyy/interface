package lesson27.hw2;

import java.util.ArrayList;

public class UserRepository {
    private static ArrayList<User> users;

    public static ArrayList<User> getUsers() {
        return users;
    }

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public static ArrayList<String> getUserNames() {
        ArrayList<String> userNames = new ArrayList<>();
        for (User user : users) {
            if (user != null)
                userNames.add(user.getName());
        }
        return userNames;
    }


    public static ArrayList<Long> getUserIds() {
        ArrayList<Long> userIds = new ArrayList<>();
        for (User user : users) {
            if (user != null)
                userIds.add(user.getId());
        }
        return userIds;
    }

    public static String getUserNameById(long id) throws IllegalArgumentException{
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user.getName();
            }
        }
        throw new IllegalArgumentException("User with id : " + id + " not found");
    }

    public static  User getUserByName(String name) throws IllegalArgumentException{
        for (User user : users) {
            if (user != null && user.getName().equals(name)) {
                return user;
            }
        }
        throw new IllegalArgumentException("User with id : " + name + " not found");
    }

    public static User findById(long id){
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        return null;
    }

    public static User getUserById(long id) throws IllegalArgumentException{
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        throw new IllegalArgumentException("User with id : " + id + " not found");
    }


    public static User getUserBySessionId(String sessionId) throws IllegalArgumentException{
        for (User user : users) {
            if (user != null && sessionId.equals(user.getSessionId()))
                return user;
        }
        throw new IllegalArgumentException("User with Sessionid : " + sessionId + " not found");

    }

    public static User save(User user) throws IllegalArgumentException{
        if (findById(user.getId()) != null) {
            throw new IllegalArgumentException("User with id : " + user.getId() + " Can not be saved");
        }else{
            users.add(user);
            return user;
        }
    }

    public static User update(User user) {
        if (findById(user.getId()) != null) {
            users.set(users.indexOf(getUserById(user.getId())), user);
            return user;
        } else{
            throw new IllegalArgumentException("User with id : " + user.getId() + " not found");
        }
    }

    public static void delete(User user) {
        if (findById(user.getId()) != null) {
         users.remove(user);
        }
        else {
            throw new IllegalArgumentException("User with id : " + user.getId() + " not found");
        }
    }

    public static  void delete(long id) throws IllegalArgumentException{
        if (findById(id) != null) {
                    users.remove(getUserById(id));
        }
        else {
            throw new IllegalArgumentException("User with id : " + id + " not found");
        }
    }
}