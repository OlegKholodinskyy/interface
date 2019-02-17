package lesson35.controller;

import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Order;
import lesson35.service.OrderService;

import java.text.ParseException;

public class OrderController {

    OrderService orderService = new OrderService();

    public  Order addOrder(Order order) throws BadRequestException, BadInputException, ParseException {
        return orderService.addOrder(order);
    }

    public  Order removeOrder(Order order){
        return orderService.removeOrder(order);
    }
}
