package dao;

import DB.DBConnector;
import UI.MenuUI;

import java.sql.*;

public class LoginDao {
    String accNumber;
    public boolean checkLogin(String name,String passWord){
        String sql="SELECT accountnumber FROM public.user WHERE (username=? and password=?)";
        Connection connection= DBConnector.getConnect();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,passWord);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                setAccNumber(resultSet.getString("accountnumber"));
                return true;


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
    //--------------------------------------------------------------------
    public void createTableUser(){
        createDB();
        createTableAcc();
        String sql="CREATE TABLE IF NOT EXISTS schemas.public.user \n" +
                "(\n" +
                "    id            integer  not null\n" +
                "        primary key,\n" +
                "    username      char(30) not null,\n" +
                "    password      char(30) not null,\n" +
                "    accountnumber char(40) not null\n" +
                "        constraint um\n" +
                "            unique\n" +
                "        constraint accountnumber\n" +
                "            references account (acountnumber)\n" +
                ");\n" +
                "\n" +
                "alter table \"user\"\n" +
                "    owner to postgres; ";
        try {
            Statement statement=DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        insertFirstUser();
    }
    //------------------------------------------------------------------------
    private void insertFirstUser(){
        String sql="INSERT INTO user (username,password,accountnumber) VALUES ('shah','1379','0023577541')";
        try {
            Statement statement=DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //-------------------------------------------------------------------------
    public String getAccNumber() {
        return accNumber;
    }
    //-------------------------------------------------------------------------

    private void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
    //-----------------------------------------------------------------------
    public void createTableAcc(){
        String sql="create table IF NOT EXISTS schemas.public.account  \n" +
                "(\n" +
                "    id           serial\n" +
                "        primary key,\n" +
                "    acountnumber char(30)         not null\n" +
                "        constraint niu\n" +
                "            unique,\n" +
                "    balance      double precision not null,\n" +
                "    minbalance   double precision not null\n" +
                ");\n" +
                "\n" +
                "alter table account\n" +
                "    owner to postgres;";
        try {
            Statement statement=DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        insertFirstAcc();
    }
    //--------------------------------------------------------------------
    private void insertFirstAcc(){
        String sql="INSERT INTO user (acountnumber,balance,minbalance) VALUES ('0023577541',10000,100)";
        try {
            Statement statement=DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------------------
    private void createDB(){
        String sql="CREATE DATABASE IF NOT EXISTS atm_db ;";
        try {
            Statement statement=DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
