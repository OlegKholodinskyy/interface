package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    // відповідає за роботу з данними
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();


    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {

        validate(transaction);
        int i = findIndexOfFreeSpace();
        transactions[i] = transaction;
        return transactions[i];
    }

    private int findIndexOfFreeSpace() throws InternalServerException {
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                return i;
            }
        }
        throw new InternalServerException("Unexpected error.");
    }


    private void validate(Transaction transaction) throws BadRequestException {

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionPerDay(transaction.getDateCreated())) {
            sum = sum + tr.getAmount();
            count++;
        }

        transactionAlreadyPresentChecker(transaction);
        limitSimpleTransactionAmountChecker(transaction);
        limitTransactionAmountPerDayChecker(sum, transaction);
        limitTransactionCountPerDayChecker(count, transaction);
        cityAlowerChecker(transaction.getCity());
        freeSpaceChesker(transaction);


    }

    private void freeSpaceChesker(Transaction transaction) throws BadRequestException {
        for (Transaction tr  : transactions) {
            if (tr == null){
                return;
            }
        }
        throw new BadRequestException("Not enough free space for transaction id : " + transaction.getId());
    }


    private void limitTransactionCountPerDayChecker(int count, Transaction transaction) throws LimitExceeded {
        if (count > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Count of transaction per day is exceeded. id transaction " + transaction.getId() + ".");
    }

    private void limitTransactionAmountPerDayChecker(int sum, Transaction transaction) throws LimitExceeded {
        if (sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Limit amount of transaction per day is exceeded. id transaction " + transaction.getId() + ".");
    }

    private void limitSimpleTransactionAmountChecker(Transaction transaction) throws LimitExceeded {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Limit transaction is exceeded. id transaction " + transaction.getId() + ".");

    }

    private void transactionAlreadyPresentChecker(Transaction transaction) throws BadRequestException {
        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction))
                throw new BadRequestException("Transaction id: " + tr.getId() + "  is already present in list");
        }
    }

    private void cityAlowerChecker(String city) throws BadRequestException {
        for (String cityName : utils.getCities()) {
            if (city == cityName) {
                return;
            }
        }
        throw new BadRequestException("City not alowed " + city);
    }

    Transaction[] transactionList() {
        return transactions;
    }

    Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                count++;
            }
        }
        Transaction[] result = new Transaction[count];
        int i = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity() == city) {
                result[i] = tr;
                i++;
            }
        }
        return result;
    }

    Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                count++;
            }
        }
        Transaction[] result = new Transaction[count];
        int i = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                result[i] = tr;
                i++;
            }
        }
        return result;
    }

    private Transaction[] getTransactionPerDay(Date dateOfCurrentTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurrentTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;

        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    count++;
                }

            }
        }
        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transact : transactions) {
            if (transact != null) {
                calendar.setTime(transact.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transact;
                    index++;
                }
            }
        }
        return result;
    }
}
