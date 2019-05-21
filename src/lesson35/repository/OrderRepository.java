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
    RoomRepository roomRepository = new RoomRepository();

    public Order saveToRepository(Order order) throws BadRequestException, IOException {
        validation(fileOrder);
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);

        String orderToString = order.getId() + ", " + order.getUser().getId() + ", " + order.getRoom().getId() + ", " +
                simpleDate.format(order.getDateFrom()) + ", " +
                simpleDate.format(order.getDateTo()) + ", " +
                order.getMoneyPaid();

        RepositoryHelper.append(orderToString, fileOrder);

        return order;
    }

    public void deleteOrder(long roomId, long userId) throws BadRequestException, IOException {
        validation(fileOrder);
        StringBuffer buffer = RepositoryHelper.excludeRequired(roomId, userId, fileOrder);
        RepositoryHelper.writeToFile(buffer,fileOrder);
        System.out.println("Order  room with id  " + roomId + " reserver by user id : " + userId + " is deleted");
    }

    public ArrayList<Order> buildArrayListOfOrders() throws BadRequestException, IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(fileOrder));
        String orderInString;
        orderArrayList.clear();
        while ((orderInString = bfr.readLine()) != null) {
            orderArrayList.add(buildOrder(orderInString));
        }
        return orderArrayList;
    }

    public Order buildOrder(String orderInString) throws BadRequestException, IOException {
        String[] orderInStringPresentationArray = orderInString.trim().split(", ");
        try {
            long id = Long.parseLong(orderInStringPresentationArray[0]);
            User user = userRepository.getUserById(Long.parseLong(orderInStringPresentationArray[1]));
            Room room = roomRepository.getRoomById(Long.parseLong(orderInStringPresentationArray[2]));
            Date dateFrom = new SimpleDateFormat("dd-MM-yyyy").parse(orderInStringPresentationArray[3]);
            Date dateTo = new SimpleDateFormat("dd-MM-yyyy").parse(orderInStringPresentationArray[4]);
            double moneyPaid = Double.parseDouble(orderInStringPresentationArray[5]);

            return  new Order(id, user, room, dateFrom, dateTo, moneyPaid);
        } catch (BadRequestException e) {
            throw new BadRequestException("bad in order.txt");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Order getOrderByRoomIdAndUserId(long userId, long roomId) throws BadRequestException {
        for (Order o : orderArrayList) {
            if (o.getUser().getId() == userId && o.getRoom().getId() ==roomId) {
                return o;
            }
        }
        throw new BadRequestException("Order with userid " + userId + " and roomId " + roomId + "not found in base");
    }

    private  void validation(File file) throws BadRequestException {

        if (!fileOrder.exists()) {
            throw new BadRequestException("File " + file.toString() + " does not exist");
        }
        if (!fileOrder.canRead()) {
            throw new BadRequestException("File " + file.toString() + " does not have permission to read");
        }
        if (!fileOrder.canWrite()) {
            throw new BadRequestException("File " + file.canRead() + " does not have permission to write");
        }
    }
}