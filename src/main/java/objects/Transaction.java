package objects;

import UI.TypeTransaction;

import java.time.LocalDateTime;

public class Transaction {
   private String typeTransaction ;
   private double transactionAmount;
   private LocalDateTime transactionDate;


    public Transaction(String typeTransaction, double transactionAmount, LocalDateTime transactionDate) {
        this.typeTransaction = typeTransaction;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
}

