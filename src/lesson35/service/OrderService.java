package lesson35.service;

import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Order;
import lesson35.model.User;
import lesson35.repository.OrderRepository;
import lesson35.repository.ReservedMapRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class OrderService {
    OrderRepository orderRepository = new OrderRepository();
    ReservedMapRepository reservedMapRepository = new ReservedMapRepository();

    public Order addOrder(Order order) throws BadInputException, BadRequestException, ParseException {
        validateBeforeRegisterOrder(order);
        checkIfOrderIsExist(order);
        checkIfRoomIsFree(order.getDateFrom(), order.getDateTo(), order.getRoom().getId());
        return orderRepository.saveToRepository(order);
    }

    private void checkIfRoomIsFree(Date dateFrom, Date dateTo, Long id) throws ParseException, BadRequestException {
        HashSet<Date> dateOrder = buildSetDates(dateFrom,dateTo);
        HashMap<Long,HashSet<Date>> map = reservedMapRepository.getReservedMapFromFile();

        for(Date d :dateOrder){
            if(map==null){
                return;
            }
            if(map.get(id).contains(d)){
                throw new BadRequestException("Room with id : " + id + "is reserved on "+ d);
            }
        }
    }

    private HashSet<Date> buildSetDates (Date dateFrom, Date dateTo) {
        HashSet<Date> dateOrder = new HashSet<>();
        long interval = 1000*60*60*24;
        long start = dateFrom.getTime();
        long end = dateTo.getTime();

        while(start<=end){
            dateOrder.add(new Date(start));
            start +=interval;
        }
        return dateOrder;
    }

    public Order removeOrder(Order order) {
        return order;
    }

    private void checkIfOrderIsExist(Order order) throws BadRequestException {

        ArrayList<Order> allOrders = OrderRepository.buildArrayListOfOrders();
        for (Order ord : allOrders) {
            if (order.equals(ord)) {
                throw new BadRequestException("Order with id: " + order.getId() + " is present in base");
            }
        }
    }

    private void validateBeforeRegisterOrder(Order order) throws BadInputException {
        if (order.getUser() == null  ||
                order.getDateFrom() == null || order.getDateTo() == null) {
            throw new BadInputException("All fields should be filled. Order with id = " + order.getId());
        }
    }
}
