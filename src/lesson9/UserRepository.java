package lesson9;

public class UserRepository {
    private User[] users;

    public User[] getUsers() {
        return users;
    }

    public UserRepository(User[] users) {
        this.users = users;
    }

    public String[] getUserNames() {
        int count = 0;
        for (User user : users) {
            if (user != null)
                count++;
        }

        String[] userNames = new String[count];
        for (int i = 0; i < users.length; i++) {
            int j = 0;
            if (users[i] != null) {
                userNames[j] = users[i].getName();
                j++;
            }
        }
        return userNames;
    }

    public long[] getUserIds() {
        int count = 0;
        for (User user : users) {
            if (user != null)
                count++;
        }

        long[] userIds = new long[count];
        for (int i = 0; i < users.length; i++) {
            int j = 0;
            if (users[i] != null) {
                userIds[j] = users[i].getId();
                j++;
            }
        }
        return userIds;
    }

    public String getUserNameById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user.getName();
            }
        }
       // System.out.println("User with id: " + id + " not found");
        return null;
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user != null && user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    private User findById(long id) {

        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        return null;
    }
    public User getUserById(long id) {

        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        return null;
    }


    public User getUserBySessionId(String sessionId) {

        for (User user : users) {
            if (user != null && sessionId.equals(user.getSessionId()))
                return user;
        }
        return null;
    }

    public User save(User user) {
        if (findById(user.getId()) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public User update(User user) {
        if (findById(user.getId()) != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].getId() == user.getId())
                    users[i] = user;
                return user;
            }
        }
        return null;
    }

    public User delete(User user) {
        if (findById(user.getId()) != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].getId() == user.getId())
                    users[i] = null;
                return user;
            }
        }
        return null;

    }

    public void delete(long id) {
        if (findById(id) != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].getId() == id) {
                    users[i] = null;
                    break;
                }
            }
        }
    }
}