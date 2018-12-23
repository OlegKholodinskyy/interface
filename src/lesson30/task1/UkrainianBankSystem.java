package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount) || !checkFund(toUser, amount) || !fromUser.getBank().getCurrency().equals(toUser.getBank().getCurrency())) {
            return;
        }
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "transfer from " + fromUser.getId() + " to " + toUser.getId());
    }


    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFund(user, amount)) {
            return;
        }
        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "fsdf");
    }

    private boolean checkFund(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            printFundingErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    @Override
    public void paySalary(User user) {
        if (!checkFund(user, user.getSalary())) {
            return;
        }
        user.setBalance(user.getBalance() + user.getSalary());
        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, user.getSalary(), "paySalary " + user.getId());
    }

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount)) {
            return;
        }
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "fsdf");

    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Cam`t withdrow money " + amount + " from user " + user.toString());
    }

    private void printFundingErrorMsg(int amount, User user) {
        System.err.println("Cam`t fund money " + amount + " to user " + user.toString());
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType transactionType, int amount, String descr) {
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, transactionType, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
