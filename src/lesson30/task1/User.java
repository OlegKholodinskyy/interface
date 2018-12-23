package lesson30.task1;

public class User {
    private long id;
    private String name;
    private double balance;
    private int monthsOfEmployment;
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

    public int getMonthsOfEmployment() {
        return monthsOfEmployment;
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
        this.monthsOfEmployment = monthsOfEmpoyment;
        this.companyName = companyName;
        this.salary = salary;
        this.bank = bank;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMonthsOfEmployment(int monthsOfEmpoyment) {
        this.monthsOfEmployment = monthsOfEmpoyment;
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
                ", monthOfEmpoyment=" + monthsOfEmployment +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                ", bank=" + bank +
                '}';
    }
}
