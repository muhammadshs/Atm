package dao;

import DB.DBConnector;
import UI.TypeTransaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class MenuDao {
    public void insertDB(double d,String accNumber){
        String sql="UPDATE public.account SET balance=? WHERE acountNumber=?";
        PreparedStatement statement= null;
        try {
            statement = DBConnector.getConnect().prepareStatement(sql);
            statement.setDouble(1,d);
            statement.setString(2,accNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insertTransaction(TypeTransaction typeTransaction, double transactionAmount,String accNumber){
        Date date=new Date();
        java.sql.Date date1= new java.sql.Date(date.getTime());
        String sql="INSERT INTO public.transaction (type,amount,date,accountnumber) VALUES (?,?,?,?)";
        PreparedStatement statement= null;
        try {
            statement = DBConnector.getConnect().prepareStatement(sql);
            statement.setString(1,typeTransaction.toString());
            statement.setDouble(2,transactionAmount);
            statement.setDate(3,date1);
            statement.setString(4,accNumber);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
