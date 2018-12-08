package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

public class Controller {
    // приймає запити від користувача і передає на інший рівень

    private TransactionDAO transactionDAO = new TransactionDAO();
    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
        return transactionDAO.save(transaction);
    }


    Transaction[] transactionList() {
        return transactionDAO.transactionList();
    }

    Transaction[] transactionList(String city) {
        return transactionDAO.transactionList(city);
    }

    Transaction[] transactionList(int amount) {
        return transactionDAO.transactionList(amount);
    }

}
