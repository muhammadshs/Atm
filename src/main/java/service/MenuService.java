package service;

import UI.InfoUI;
import UI.MenuUI;
import UI.TransactionListUI;
import dao.AccDao;
import dao.TransactionDao;
import enum_pac.PageEnum;
import enum_pac.TypeTransaction;
import input.Validation;
import model.Back;

public class MenuService {
   private AccDao accDao;
    private double balance, minBalance;
    private String accountNumber;
    private TransactionDao transactionDao;


    public MenuService(String accountNumber,MenuUI menuUI) {
        this.accountNumber=accountNumber;

        transactionDao = new TransactionDao();
        accDao = new AccDao();
        double[] doubles = accDao.selectAcc(accountNumber);
        balance = doubles[0];
        minBalance = doubles[1];
    }
    public void withDraw(String withDraw){
        double d= Validation.valDouble(withDraw.trim());
        if(balance-minBalance>=d){
            balance=balance-d;
            accDao.insertDB(balance,accountNumber);
            transactionDao.insertTransaction(TypeTransaction.withdraw,d,getAccountNumber());

        }
    }

    public void deposit(String deposit){
        Double d= Validation.valDouble(deposit.trim());
        //System.out.println(d);
        if(balance-minBalance>=d){
            balance=balance+d;
            accDao.insertDB(balance,accountNumber);
            transactionDao.insertTransaction(TypeTransaction.deposit,d,getAccountNumber());


        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


}
