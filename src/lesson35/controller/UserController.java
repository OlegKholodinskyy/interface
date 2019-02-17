package lesson35.controller;

import lesson35.exception.BadRequestException;
import lesson35.exception.BadInputException;
import lesson35.model.User;
import lesson35.service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public User registerUser(User user) throws BadInputException, BadRequestException {
            return userService.registerUser(user);
    }
}
