package lesson35.demo;

import lesson35.exception.BadRequestException;
import lesson35.controller.UserController;
import lesson35.exception.BadInputException;
import lesson35.model.User;
import lesson35.model.UserType;
import lesson35.repository.UserRepository;
import lesson35.service.Loaders;

public class DemoUser {
    public static void main(String[] args) throws BadRequestException {

        Loaders.loadOrderArrayList();
        Loaders.loadUserArrayList();
        Loaders.loadMapObjectId();

        User userFirst = new User("Oleg", "1234", "Ukraine", UserType.ADMIN);
        User userSecond = new User("Ivan", "1234", "Ukraine", UserType.ADMIN);
        User userThird = new User("Oleg", "1234", "Ukraine", UserType.ADMIN);
        User userFourth = new User("Irina", "1234", "Germany", UserType.USER);

        UserController userController = new UserController();

        try {
            userController.registerUser(userFirst);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }
        try {
            userController.registerUser(userSecond);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }
        try {
            userController.registerUser(userThird);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            userController.registerUser(userFourth);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(UserRepository.getUserFromFileById(239));
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        }


    }
}