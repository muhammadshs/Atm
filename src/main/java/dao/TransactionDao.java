package dao;

import DB.DBConnector;
import UI.TypeTransaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TransactionDao {
    public static ArrayList<Object[]> getTransaction(String accNumber) {
        ArrayList<Object[]> list=new ArrayList<>();
        String sql = "SELECT type,amount,date FROM public.transaction WHERE accountnumber=?";
        try {
            PreparedStatement statement = DBConnector.getConnect().prepareStatement(sql);
            statement.setString(1, accNumber);
            ResultSet resultSet = statement.executeQuery();


            int num = 0;
            while (resultSet.next()) {
                num = ++num;
                Object[] o = new Object[4];
                o[0] = num;
                o[1] = resultSet.getString("type");
                o[2] = resultSet.getDouble("amount");
                o[3] = resultSet.getDate("date");
                list.add(o);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void insertTransaction(TypeTransaction typeTransaction, double transactionAmount, String accNumber){
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
