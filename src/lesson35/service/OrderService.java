package lesson35.service;

import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Order;
import lesson35.repository.OrderRepository;
import lesson35.repository.ReservedMapRepository;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class OrderService {
    OrderRepository orderRepository = new OrderRepository();
    ReservedMapRepository reservedMapRepository = new ReservedMapRepository();

    public Order addOrder(Order order) throws BadInputException, BadRequestException, ParseException, IOException {
        ArrayList<Date> arrayListDates = buildArrayListDates(order.getDateFrom(), order.getDateTo());

        validateBeforeRegisterOrder(order);
        checkIfOrderIsExist(order);
        checkIfRoomIsFree(arrayListDates, order.getRoom().getId());

        return orderRepository.saveToRepository(order, arrayListDates);

    }

    private void checkIfRoomIsFree(ArrayList<Date> arrayListDates, Long id) throws ParseException, BadRequestException {

        HashMap<Long, ArrayList<Date>> map = reservedMapRepository.getReservedMapFromFile();

        for (Date d : arrayListDates) {
            if (map == null || map.get(id) == null) {
                return;
            }

            if (map.get(id).contains(d)) {
                throw new BadRequestException("Room with id : " + id + " is reserved on " + d);
            }
        }
    }

    /*
    повертає список дат в проміжку між початком та кінцем
     */
    public ArrayList<Date> buildArrayListDates(Date dateFrom, Date dateTo) {
        ArrayList<Date> dateOrder = new ArrayList<>();
        long interval = 1000 * 60 * 60 * 24;
        long start = dateFrom.getTime();
        long end = dateTo.getTime();

        while (start <= end) {
            dateOrder.add(new Date(start));
            start += interval;
        }
        return dateOrder;
    }

    private void checkIfOrderIsExist(Order order) throws BadRequestException, IOException {

        ArrayList<Order> allOrders = orderRepository.buildArrayListOfOrders();
        for (Order ord : allOrders) {
            if (order.equals(ord)) {
                throw new BadRequestException("Order room id : " + order.getRoom().getId() + " from  " + order.getDateFrom() + " to " + order.getDateTo() + " is present in base");
            }
        }
    }

    private void validateBeforeRegisterOrder(Order order) throws BadInputException {
        if (order.getUser() == null ||
                order.getDateFrom() == null || order.getDateTo() == null) {
            throw new BadInputException("All fields should be filled. Order with id = " + order.getId());
        }
    }

    /*
    1 - знаходимо відповідний ордер в репозиторію
    2 - видаляємо з файлу order.txt
    3 - видаляємо з файлу dateReservesMap - передаємо roomId  і список дат з відповідного ордеру
     */


    public void dellOrder(long roomId, long userId) throws BadRequestException, ParseException, IOException {
        Order o = orderRepository.getOrderByRoomIdAndUserId(userId,roomId);
        orderRepository.deleteOrder(roomId, userId);
        System.out.println("Order deleted from order.txt.   roomId : " + roomId);

        reservedMapRepository.dellDataIfOrderIsDeleted(roomId, buildArrayListDates(o.getDateFrom(),o.getDateTo()) );
        System.out.println("Date is  deleted from reservedMap.txt.   roomId : " + roomId);

    }
}
