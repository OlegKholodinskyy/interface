package lesson35.repository;

import lesson35.exception.BadRequestException;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.service.OrderService;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderRepository {

    private static ArrayList<Order> orderArrayList = new ArrayList<>();
    File fileOrder = new File("C:\\java\\order.txt");
    ReservedMapRepository reservedMapRepository = new ReservedMapRepository();
    UserRepository userRepository = new UserRepository();

    public  Order saveToRepository(Order order, ArrayList<Date> arrayListDates) {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);

        String orderToString = order.getId() + ", " + order.getUser().getId() + ", " + order.getRoom().getId() + ", " +
                simpleDate.format(order.getDateFrom()) + ", " +
                simpleDate.format(order.getDateTo()) + ", " +
                order.getMoneyPaid();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOrder, true))) {
             bufferedWriter.append(orderToString + "\n");
             reservedMapRepository.saveToFileDateReserves(order.getRoom().getId(),arrayListDates);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    public  ArrayList<Order> buildArrayListOfOrders() throws BadRequestException, IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(fileOrder));
            String orderInStringPresentation;
            orderArrayList.clear();
            while ((orderInStringPresentation = bfr.readLine()) != null) {
                orderArrayList.add(buildOrder(orderInStringPresentation));
            }
        return orderArrayList;
    }

    public  Order buildOrder(String orderInStringPresentation) throws BadRequestException {
        Order order;
        String[] orderInStringPresentationArray = orderInStringPresentation.trim().split(", ");

        try  {
            long id = Long.parseLong(orderInStringPresentationArray[0]);
            User user = userRepository.getUserFromFileById(Long.parseLong(orderInStringPresentationArray[1]));
            Room room = RoomRepository.getRoomFromFileById(Long.parseLong(orderInStringPresentationArray[2]));
            Date dateFrom = new SimpleDateFormat("dd-MM-yyyy").parse(orderInStringPresentationArray[3]);
            Date dateTo =new SimpleDateFormat("dd-MM-yyyy").parse(orderInStringPresentationArray[4]);
            double moneyPaid = Double.parseDouble(orderInStringPresentationArray[5]);

            return order = new Order(id, user, room, dateFrom, dateTo, moneyPaid);
        } catch (BadRequestException e){
            throw new BadRequestException("bad in order.txt");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public  Order getOrderById(long id) throws BadRequestException {

        for (Order o : orderArrayList){
            if (o.getId()==id){
                return o;
            }
        }
        throw new BadRequestException("Order with id " + id + "not found in base");
    }
}