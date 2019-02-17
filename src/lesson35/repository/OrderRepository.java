package lesson35.repository;

import com.sun.org.apache.xpath.internal.operations.Or;
import lesson30.hw2.CustomerDAO;
import lesson35.exception.BadInputException;
import lesson35.exception.BadRequestException;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderRepository {

    private static ArrayList<Order> orderArrayList = new ArrayList<>();
    static File file = new File("C:\\java\\order.txt");

    public static Order saveToRepository(Order order) {
        String orderToString = order.getId() + ", " + order.getUser().getId() + ", " + order.getRoom().getId() + ", " +
                new SimpleDateFormat("DD-MM-YYYY").format(order.getDateFrom()) + ", " +
                new SimpleDateFormat("DD-MM-YYYY").format(order.getDateTo()) + ", " +
                order.getMoneyPaid();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(orderToString + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    public static ArrayList<Order> buildArrayListOfOrders() throws BadRequestException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String orderInStringPresentation;
            while ((orderInStringPresentation = br.readLine()) != null) {
                orderArrayList.add(buildOrder(orderInStringPresentation));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderArrayList;
    }

    public static Order buildOrder(String orderInStringPresentation) throws BadRequestException {
        Order order;
        String[] orderInStringPresentationArray = orderInStringPresentation.trim().split(", ");

        try  {
            long id = Long.parseLong(orderInStringPresentationArray[0]);
            User user = UserRepository.getUserFromFileById(Long.parseLong(orderInStringPresentationArray[1]));
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

    public static Order getOrderById(long id) throws BadRequestException {

        for (Order o : orderArrayList){
            if (o.getId()==id){
                return o;
            }
        }
        throw new BadRequestException("Order with id " + id + "not found in base");
    }
}