package lesson25.homework.exception;

import lesson25.homework.exception.BadRequestException;

public class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
