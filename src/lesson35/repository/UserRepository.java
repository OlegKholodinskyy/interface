package lesson35.repository;

import lesson35.exception.BadRequestException;
import lesson35.model.User;
import lesson35.model.UserType;
import lesson35.service.Loaders;

import java.io.*;
import java.util.ArrayList;

public class UserRepository {

    File file = new File("C:\\java\\user.txt");

    public User registerUser(User user) throws BadRequestException {
        saveUserToFile(user);
        return user;
    }

    private void saveUserToFile(User user) {
        String userToString = user.getId() + ", " + user.getUserName() + ", " + user.getPassword() + ", " +
                user.getCountry() + ", " + user.getUserType();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(userToString + "\n");
            bufferedWriter.flush();
            Loaders.loadUserArrayList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static User getUserFromFileById(long id) throws BadRequestException {
        ArrayList<User> userArrayList = buildArrayListOfUsers();
        for (User user : userArrayList) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new BadRequestException("User wiht id: " + id + "not found in base");
    }


    public static User buildUser(String userInStringPresentation) {

        User user;

        String[] userInStringPresentationArray = userInStringPresentation.trim().split(", ");

        long id = Long.parseLong(userInStringPresentationArray[0]);
        String username = userInStringPresentationArray[1];
        String pass = userInStringPresentationArray[2];
        String country = userInStringPresentationArray[3];
        UserType userType = UserType.valueOf(userInStringPresentationArray[4]);

        return user = new User(id, username, pass, country, userType);

    }

    public static ArrayList<User> buildArrayListOfUsers() {
        ArrayList<User> userArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\java\\user.txt"))) {
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


}
