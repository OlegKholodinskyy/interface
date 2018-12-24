package lesson30.hw2;

public class Demo {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1001, "Ivan", "USA", 1000);
        Customer customer2 = new Customer(1002, "Stepan", "Ukraine", 500);
        Customer customer3 = new Customer(1003, "Haints", "Germeny", 800);

        CustomerDAO.add(customer1);
        CustomerDAO.add(customer2);
        CustomerDAO.add(customer3);

        for (Customer customer : CustomerDAO.getCustomers())
            System.out.println(customer);


        CustomerDAO.delete(customer2);
        customer3.setMonthlyPay(2000);
        CustomerDAO.update(customer3);
        System.out.println();
        for (Customer customer : CustomerDAO.getCustomers())
            System.out.println(customer);

    }
}
