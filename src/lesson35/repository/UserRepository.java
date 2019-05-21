package lesson35.repository;

import lesson35.exception.BadRequestException;
import lesson35.model.User;
import lesson35.model.UserType;
import lesson35.service.Loaders;

import java.io.*;
import java.util.ArrayList;

public class UserRepository {

    File file = new File("C:\\java\\user.txt");

    public User registerUser(User user) throws BadRequestException, IOException {
        saveUserToFile(user);
        return user;
    }

    private User saveUserToFile(User user) throws BadRequestException, IOException {
        validation(file);
        String userInString = user.getId() + ", " + user.getUserName() + ", " + user.getPassword() + ", " +
                user.getCountry() + ", " + user.getUserType();
        RepositoryHelper.append(userInString, file);
        return user;
    }

    public static User buildUser(String userInString) {

        User user;

        String[] userArrInString = userInString.trim().split(", ");

        long id = Long.parseLong(userArrInString[0]);
        String username = userArrInString[1];
        String pass = userArrInString[2];
        String country = userArrInString[3];
        UserType userType = UserType.valueOf(userArrInString[4]);

        return user = new User(id, username, pass, country, userType);

    }

    public ArrayList<User> buildArrayListOfUsers() throws BadRequestException, FileNotFoundException {
        validation(file);
        ArrayList<User> userArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String userInStringPresentation;
            while ((userInStringPresentation = br.readLine()) != null) {
                userArrayList.add(buildUser(userInStringPresentation));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userArrayList;
    }


    public User getUserByName(String userName) throws BadRequestException, FileNotFoundException {
        ArrayList<User> userArrayList = buildArrayListOfUsers();
        for (User user : userArrayList) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        throw new BadRequestException("User wiht name: " + userName + "not found in base");
    }

    public User getUserById(long userId) throws BadRequestException, IOException {
        String userInString = RepositoryHelper.getStringById(userId, file);
        if (userInString != null) {
            return buildUser(userInString);
        }
        throw new BadRequestException("User wiht name: " + userId + "not found in base");
    }

    public long deleteUser(long userId) throws BadRequestException, IOException {
        validation(file);
        StringBuffer buffer = RepositoryHelper.excludeRequired(userId, file);
        RepositoryHelper.writeToFile(buffer, file);
        System.out.println("User with id " + userId + " is deleted");
        return userId;
    }

    private static void validation(File file) throws BadRequestException, FileNotFoundException {

        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.toString() + " does not exist");
        }
        if (!file.canRead()) {
            throw new BadRequestException("File " + file.toString() + " does not have permission to read");
        }
        if (!file.canWrite()) {
            throw new BadRequestException("File " + file.canRead() + " does not have permission to write");
        }
    }

}
