package lesson12;

public class Main {

    public static void main(String[] args) {


        Main main = new Main();

        Bank usBank = new USBank(1234, "USA", Currency.USD, 150, 2000, 2, 5234562);
        Bank chinaBank = new ChinaBank(1345, "China", Currency.USD, 300, 1000, 5, 5425666);
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 2553223);

        User user1 = new User(1001, "Denis", 12200, 40, "GMD", 1500, euBank);
        User user2 = new User(1002, "Taras", 150, 4, "LG", 500, euBank);

        User user3 = new User(1003, "Ivan", 1443, 12, "Samsung", 1000, usBank);
        User user4 = new User(1004, "Donald", 31234, 89, "Samsung", 4000, usBank);

        User user5 = new User(1005, "Sum", 5423, 12, "ETH", 500, chinaBank);
        User user6 = new User(1006, "Mun", 0, 0, "HVN", 300, chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();
/**
        System.out.println("++++++++++++++ Withdraw ++++++++++++++");
        main.withdraw(user1, 150, bankSystem);
        main.withdraw(user2, 10_000, bankSystem);
        main.withdraw(user3, 1_000, bankSystem);
        main.withdraw(user4, 10, bankSystem);
        main.withdraw(user5, 25, bankSystem);
        main.withdraw(user6, 10, bankSystem);
        main.sleep(300);
        System.out.println("++++++++++++++ Fund +++++++++++++++++++");
        main.fund(user1, 102_500, bankSystem);
        main.fund(user2, 1_000, bankSystem);
        main.fund(user3, 108_000, bankSystem);
        main.fund(user4, 1, bankSystem);
        main.fund(user5, 25, bankSystem);
        main.fund(user6, 10, bankSystem);
        main.sleep(300);
        System.out.println("++++++++++++++ Transfer +++++++++++++++++++");
        main.transferMoney(user1, user6, 102_500, bankSystem);
        main.transferMoney(user2, user5,1_000, bankSystem);
 */
        main.transferMoney(user3, user5,10, bankSystem);
        /**
        main.transferMoney(user4, user2,1, bankSystem);
        main.transferMoney(user5, user1,25, bankSystem);
        main.transferMoney(user6, user4,10, bankSystem);
        main.sleep(300);
        System.out.println("+++++++++++++Salary+++++++++++++++++");
        main.paySalary(user1,bankSystem);
        main.paySalary(user2,bankSystem);
        main.paySalary(user3,bankSystem);
        main.paySalary(user4,bankSystem);
        main.paySalary(user5,bankSystem);
        main.paySalary(user6,bankSystem);
*/
    }

    private void paySalary(User user, BankSystem bankSystem){
        System.out.println("Balance " + user.getName() + " before salary is " + user.getBalance());
        sleep(100);
        bankSystem.paySalary(user);
        sleep(100);
        System.out.println("Balance " + user.getName() + " after paying salary  now is " + user.getBalance());
    }

    private void transferMoney (User fromUser, User toUser, int amount,BankSystem bankSystem ){
        System.out.println("Transfer " + amount + " from  " + fromUser.getName() + "(" + fromUser.getBalance()+ ") to " + toUser.getName() + "(" + toUser.getBalance()+ ")");
        sleep(100);
        bankSystem.transferMoney(fromUser,toUser,amount );
        sleep(100);
        System.out.println("Balance " + fromUser.getName() + "(" + fromUser.getBalance()+ ") and balance " + toUser.getName() + "(" + toUser.getBalance()+ ")");

    };


    private void withdraw(User user, int amount, BankSystem bankSystem) {
        System.out.println("Balance " + user.getName() + " before withdraw " + amount + " is " + user.getBalance());
        sleep(100);
        bankSystem.withdraw(user, amount);
        sleep(100);
        System.out.println("Balance " + user.getName() + " now is " + user.getBalance());
    }

    private void fund(User user, int amount, BankSystem bankSystem) {
        System.out.println("Balance " + user.getName() + " before fund " + amount + " is " + user.getBalance());
        sleep(100);
        bankSystem.fund(user, amount);
        sleep(100);
        System.out.println("Balance " + user.getName() + " now is " + user.getBalance());
    }

    void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
