package lesson22.task2;

import lesson22.task2.exception.BadRequestException;
import lesson22.task2.exception.InternalServerException;

public class Controller {
    // приймає запити від користувача і передає на інший рівень

    public static Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
        return TransactionDAO.save(transaction);
    }


    public static Transaction[] transactionList() {
        return TransactionDAO.transactionList();
    }

    public static Transaction[] transactionList(String city) {
        return TransactionDAO.transactionList(city);
    }

    public static Transaction[] transactionList(int amount) {
        return TransactionDAO.transactionList(amount);
    }

}
