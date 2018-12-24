package lesson22_controller_Dao.task2;

import lesson22_controller_Dao.task2.exception.BadRequestException;
import lesson22_controller_Dao.task2.exception.InternalServerException;
import lesson22_controller_Dao.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    // відповідає за роботу з данними
    private static Transaction[] transactions = new Transaction[10];



    public static Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
        int index = 0;
        validate(transaction);

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                index = i;
                transactions[i] = transaction;
                return transactions[i];
            }
        }
        throw new InternalServerException("Unexpected error.");
    }




    private static void validate(Transaction transaction) throws BadRequestException, InternalServerException {

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionPerDay(transaction.getDateCreated())) {
            sum = sum + tr.getAmount();
            count++;
        }

        freeSpaceChesker(transaction);
        cityAlowerChecker(transaction);
        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction)) {
                throw new BadRequestException("Transaction id: " + tr.getId() + "  is already present in list");
            }
        }

        if (transaction.getAmount() > Utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Limit transaction is exceeded. id transaction " + transaction.getId() + ".");
        }

        if (sum + transaction.getAmount() > Utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Limit amount of transaction per day is exceeded. id transaction " + transaction.getId() + ".");
        }

        if (count + 1 > Utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Count of transaction per day is exceeded. id transaction " + transaction.getId() + ".");
        }


    }

    private static void freeSpaceChesker(Transaction transaction) throws InternalServerException, BadRequestException {
        if (transaction == null)
            throw new BadRequestException("Transaction is null .Cannot be saved:" + transaction.getId());
        for (Transaction tr : transactions) {
            if (tr == null) {
                return;
            }
        }
        throw new InternalServerException("Not enough free space for transaction id : " + transaction.getId());
    }

    private static void cityAlowerChecker(Transaction transaction) throws BadRequestException {
        for (String cityName : Utils.getCities()) {
            if (transaction.getCity().equals(cityName)) {
                return;
            }
        }
        throw new BadRequestException("Transaction is not allowed in city. " + transaction.getId());
    }

    public static Transaction[] transactionList() {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                count++;
            }
        }

        Transaction[] transactionsResult = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                transactionsResult[index] = transaction;
                index++;
            }
        }
        return transactionsResult;

    }

    public static Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
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

    public static Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
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

    private static Transaction[] getTransactionPerDay(Date dateOfCurrentTransaction) {
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
