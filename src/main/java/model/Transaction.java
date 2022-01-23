package model;

import java.util.Date;

public class Transaction {
   private String typeTransaction ;
   private double transactionAmount;
   private Date transactionDate;
    private int id;

    /*public Transaction(String typeTransaction, double transactionAmount, LocalDateTime transactionDate) {
        this.typeTransaction = typeTransaction;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }*/

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

