package lesson30.task1;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        UkrainianBankSystem bankSystem = new UkrainianBankSystem();
//        Bank usBank = new USBank(1234, "USA", Currency.USD, 150, 2000, 2, 5234562);
//        Bank chinaBank = new ChinaBank(1345, "China", Currency.USD, 300, 1000, 5, 5425666);
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 2553223);

        User user1 = new User(1001, "Denis", 12200, 40, "GMD", 1500, euBank);

        bankSystem.withdraw(user1, 150);

            Thread.sleep(1000);

        bankSystem.withdraw(user1, 10);
        Thread.sleep(1000);

        bankSystem.fund(user1, 150);
        Thread.sleep(1000);

        bankSystem.withdraw(user1, 20);
        Thread.sleep(1000);

        bankSystem.paySalary(user1);
        Thread.sleep(1000);

        for (Transaction transaction : bankSystem.getTransactions())
            System.out.println(transaction);
    }
}
