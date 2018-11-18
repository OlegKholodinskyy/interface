package lesson12;

public class UkrainianBankSystem implements BankSystem {
    @Override
    public void withdraw(User user, int amount) {
        int limitOfWithdrawal = user.getBank().getLimitOfWithdrawal();
        if (amount > limitOfWithdrawal){
            System.err.println("Cam`t withdrow money " + amount + " from user " + user.toString());
            return;
        }
    }

    @Override
    public void fund(User user, int amount) {

    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

    }

    @Override
    public void paySalary(User user) {

    }
}
