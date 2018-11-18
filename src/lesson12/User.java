package lesson12;

import lesson12.Bank;

public class User {
    private long id;
    private String name;
    private double balance;
    private int monthOfEmpoyment;
    private String companyName;
    private int salary;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public int getMonthOfEmpoyment() {
        return monthOfEmpoyment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getSalary() {
        return salary;
    }

    public Bank getBank() {
        return bank;
    }

    private Bank bank;

    public User(long id, String name, double balance, int monthOfEmpoyment, String companyName, int salary, Bank bank) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.monthOfEmpoyment = monthOfEmpoyment;
        this.companyName = companyName;
        this.salary = salary;
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", monthOfEmpoyment=" + monthOfEmpoyment +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                ", bank=" + bank +
                '}';
    }
}
