package model;

public class User {
    private int id;
    private Account acc;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
