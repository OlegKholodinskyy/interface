package lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void fund(User user, int amount) {
        if (!checkFund(user, amount)) {
            return;
        }
        user.setBalance(user.getBalance() + amount);
    }

    private boolean checkFund(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            printFundingErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount)) {
            return;
        }
        if (!checkFund(toUser, amount)) {
            return;
        }

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);
    }

    @Override
    public void paySalary(User user) {
        if (!checkFund(user, user.getSalary())) {
            return;
        }
        user.setBalance(user.getBalance() + user.getSalary());

    }

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount)) {
            return;
        }
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Cam`t withdrow money " + amount + " from user " + user.toString());
    }

    private void printFundingErrorMsg(int amount, User user) {
        System.err.println("Cam`t fund money " + amount + " to user " + user.toString());
    }
}
