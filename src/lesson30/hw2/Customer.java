package lesson30.hw2;

import java.util.Objects;

public class Customer {

    private long id;
    private String name;
    private String country;
    private int monthlyPay;

    public Customer(long id, String name, String country, int monthlyPay) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.monthlyPay = monthlyPay;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(int monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", monthlyPay=" + monthlyPay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name) &&
                Objects.equals(country, customer.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, country);
    }

}
