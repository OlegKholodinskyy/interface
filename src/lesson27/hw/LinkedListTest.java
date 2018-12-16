package lesson27.hw;

import java.util.LinkedList;

public class LinkedListTest {

    public static LinkedList useList() {
        Order orderTest = new Order(100, "ua", "Name1", "Eldorado");

/*
Add (E e)
*/
        LinkedList<Order> orderLinkedList = new LinkedList<>();
        orderLinkedList.add(orderTest);
        orderLinkedList.add(new Order(100, "ua", "Name1", "Eldorado"));
        orderLinkedList.add(null);
        orderLinkedList.add(new Order(200, "usd", "Name5", "ATB"));

/*
Add (int index, E element)
 */

        orderLinkedList.add(2, new Order(500, "euro", "Name2", "Epitsenrt"));
        orderLinkedList.add(2, new Order(400, "euro", "Name4", "Shop"));
/*
remove (int index);
 */
        orderLinkedList.remove(4);

/*
remove (Object o)
*/
        orderLinkedList.remove(orderTest);

/*
addAll (Collection c)
 */
        LinkedList<Order> orderLinkedList1 = new LinkedList<>();
        orderLinkedList.add(orderTest);
        orderLinkedList.add(new Order(150, "euro", "Name7", "Collection2"));
        orderLinkedList1.addAll(orderLinkedList);
        orderLinkedList.addAll(orderLinkedList1);
/*
clear
 */
        orderLinkedList1.clear();
 /*
subList(int fromIndex, int toIndex)
 */
        LinkedList<Order> orderLinkedListSubList = new LinkedList<Order>(orderLinkedList.subList(1, 6));
        orderLinkedList = orderLinkedListSubList;
/*
set  (int index, E element)
 */
        orderLinkedList.set(0, new Order(999, "btc", "NameBtc", "TradeOrg"));
/*
boolean contains(Object o)
*/
        System.out.println("contains : " + orderLinkedList.contains(orderTest));
/*
        Object[] toArray();
*/
        Order[] orderLinkedListArray = new Order[orderLinkedList.size()];
        orderLinkedListArray = orderLinkedList.toArray(orderLinkedListArray);
        System.out.println("To array");
        for (Order o : orderLinkedListArray) {
            if (o != null)
                System.out.println(o);
        }
        System.out.println("END - To array");
        System.out.println();

        Object[] obArray = orderLinkedList.toArray();
        for (Object o : obArray) {
            if (o != null)
                System.out.println(o);
        }
        System.out.println("END 2 - To array");
        System.out.println();
        return orderLinkedList;
    }


    public static void main(String[] args) throws IllegalArgumentException {

        LinkedList<Order> testLinkedList = useList();

        if (testLinkedList == null || testLinkedList.isEmpty())
            throw new IllegalArgumentException("Colleсtion is empty");

        for (Order order : testLinkedList) {
            if (order == null) {
                System.out.println("null");
                continue;
            }
            System.out.println(order.toString());
        }
    }
}