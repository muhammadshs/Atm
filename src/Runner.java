import UI.LoginUI;
import UI.MenuUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        MenuUI menuUI=new MenuUI();
        //LoginUI loginUI=new LoginUI();
        User[] users = new User[1];
        users[0] = new User(new Account("5000", 200, 100), 1234, "niush");
        System.out.println("----welcome ATM---");
        System.out.println("Please enter your Username");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Please enter your Password");
        int password = scanner.nextInt();
        System.out.println("Please choice your goal");
        for (User user : users) {
            if (userName.equals(user.getUserName()) && password == user.getPass()) {
                System.out.println("********* welcome *******");
                System.out.println("1-" + Menu.Inventory);
                System.out.println("2-" + Menu.Withdraw);
                System.out.println("3-" + Menu.Deposit);
                System.out.println("4-" + Menu.Transaction);
                System.out.println("5-" + Menu.Exit);
                int a = scanner.nextInt();
                switch (a) {
                    case 1:
                        System.out.println("your balance:" + user.getAcc().getBalance());
                        break;
                    case 2:

                        System.out.println("Decrease Amount: ");
                        double withDraw = scanner.nextDouble();
                        user.getAcc().withDraw(withDraw);
                        user.getAcc().setTransaction(new Transaction(TypeTransaction.withdraw,withDraw, LocalDateTime.now()));
                        System.out.println("******************");
                        System.out.println("Your Balance:"+user.getAcc().getBalance());
                        break;
                    case 3:
                        System.out.println("Increase Amount:");
                        double dep = scanner.nextDouble();
                        user.getAcc().deposit(dep);
                        user.getAcc().setTransaction(new Transaction(TypeTransaction.deposit,dep,LocalDateTime.now()));
                        System.out.println("******************");
                        System.out.println("Your Balance:"+user.getAcc().getBalance());
                        break;
                    case 4:
                        System.out.println("Last 10 Transaction:");
                        ArrayList<Transaction> ar=user.getAcc().getListTransaction();
                        int x=0;
                        if(ar.size()>10){
                            x=10;
                        }else{
                            x=ar.size();
                        }
                        for(int i=0;i<x;i++ ){
                            Transaction trans=ar.get(i);
                            System.out.println("Type : "+trans.getTypeTransaction()+"Amount : " +trans.getTransactionAmount()+"Date : "+ trans.getTransactionDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString());
                        }
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Error this is not range numbers please enter again");

                }
            }

        }
    }
}
