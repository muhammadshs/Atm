import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
   private TypeTransaction typeTransaction ;
   private double transactionAmount;
   private LocalDateTime transactionDate;


    public Transaction(TypeTransaction typeTransaction, double transactionAmount, LocalDateTime transactionDate) {
        this.typeTransaction = typeTransaction;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public String getTypeTransaction() {
        return typeTransaction.toString();
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
}

