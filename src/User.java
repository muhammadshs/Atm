public class User {
    Account acc;
    private int pass;
    private String userName;

    public User(Account acc, int pass, String userName) {
        this.acc = acc;
        this.pass = pass;
        this.userName = userName;
    }

    public Account getAcc() {
        return acc;
    }

    public int getPass() {
        return pass;
    }

    public String getUserName() {
        return userName;
    }
}
