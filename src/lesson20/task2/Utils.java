package lesson20.task2;

public class Utils {
    private int limitTransactionsPerDayCount=10;
    private int limitTransactionsPerDayAmount=100;
    private int limitSimpleTransactionAmount =10;
    private String[] cities = {"Kiev", "Odessa"};

    public Utils() {
    }


    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
