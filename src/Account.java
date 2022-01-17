import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;



public class Account {
    private String accountNumber;
    private double amount;
    private double balance;
    private double minBalance;
    private ArrayList<Transaction> listTransaction=new ArrayList<>();

    public Account(String accountNumber, double balance, double minBalance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)  {
        if(Util.checkNumeric(accountNumber)){
            this.accountNumber = accountNumber;
        }
        else {
            throw new InvalidInputException();
        }

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
    public void deposit(double depo){
        setBalance(getBalance()+depo);


        listTransaction.add(new Transaction(TypeTransaction.deposit,depo,java.time.LocalDateTime.now()));

    }
    public void withDraw(double decreas){
        if(decreas<=getBalance()-getMinBalance()){
        setBalance(getBalance()-decreas);
        listTransaction.add(new Transaction(TypeTransaction.withdraw,decreas,java.time.LocalDateTime.now()));
        }else{
           throw new InvalidInputException();
        }

    }

    public ArrayList<Transaction> getListTransaction() {
        return listTransaction;
    }
    public void setTransaction(Transaction add){
        listTransaction.add(add);
    }
}
