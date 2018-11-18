package lesson12;

import lesson12.Bank;

public class User {
    private long id;
    private String name;
    private double balance;
    private int monthsOfEmpoyment;
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

    public int getMonthsOfEmpoyment() {
        return monthsOfEmpoyment;
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

    public User(long id, String name, double balance, int monthsOfEmpoyment, String companyName, int salary, Bank bank) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.monthsOfEmpoyment = monthsOfEmpoyment;
        this.companyName = companyName;
        this.salary = salary;
        this.bank = bank;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMonthsOfEmpoyment(int monthsOfEmpoyment) {
        this.monthsOfEmpoyment = monthsOfEmpoyment;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", monthOfEmpoyment=" + monthsOfEmpoyment +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                ", bank=" + bank +
                '}';
    }
}
