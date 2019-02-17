package lesson35.service;

import lesson35.exception.BadRequestException;
import lesson35.exception.BadInputException;
import lesson35.model.User;
import lesson35.repository.UserRepository;

import java.util.ArrayList;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) throws BadInputException, BadRequestException {

        validateBeforeRegisterUser(user);
        checkIfUserIsExist(user);
        return userRepository.registerUser(user);
    }

    private void checkIfUserIsExist(User user) throws BadRequestException {

        ArrayList<User> allUsers = Loaders.getUsersArrayList();
        for (User usr : allUsers) {
            if (user.equals(usr)) {
                throw new BadRequestException("User with name: " + user.getUserName() + " is present in base");
            }
        }
    }

    private void validateBeforeRegisterUser(User user) throws BadInputException {
        if (user.getUserName() == null || user.getPassword() == null ||
                user.getCountry() == null || user.getUserType() == null) {
            throw new BadInputException("All fields should be filled. User with id = " + user.getId());
        }
    }
}
