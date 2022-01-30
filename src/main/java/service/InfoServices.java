package service;

public class InfoServices {
    private int i;
    private double balance;

    public InfoServices(int i, double balance) {
        this.i = i;
        this.balance = balance;

    }

    public String setText() {
        String massage;
        switch (i) {
            case 1:
                massage = "your inventory is : " + balance;
                return massage;
                // System.out.println(massage);

            case 2:
                massage = "<html> Deposit is successful ----->>>> </br>  your inventory is : " + balance +"</html>";
                return massage;
                //System.out.println(massage);

            case 3:
                massage = "<html> Withdraw is successful ----->>>> </br>  your inventory is : " + balance +"</html>";
                return massage;
                // System.out.println(massage);

            case 5:
                massage="<html><b>See You Later</b></html>";
                return massage;
                //System.out.println("see");


        }
        return "Error";
    }
    public static void exit(int i){
        if(i==5){
            try {
                Thread.sleep(1000);
                System.exit(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}
