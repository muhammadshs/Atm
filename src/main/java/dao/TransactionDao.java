package dao;

import UI.TypeTransaction;
import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TransactionDao {
    private static Connection connection;
    static {
        connection=DBConnector.getConnect();
    }
    public static ArrayList<Transaction> getTransaction(String accNumber) {
        ArrayList<Transaction> list=new ArrayList<>();
        String sql = "SELECT type,amount,date FROM public.transaction WHERE accountnumber=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, accNumber);
            ResultSet resultSet = statement.executeQuery();


            int num = 0;
            while (resultSet.next()) {
                num = ++num;
                Transaction transaction=new Transaction();
                transaction.setId(num);
                transaction.setTypeTransaction(resultSet.getString("type"));
                transaction.setTransactionAmount(resultSet.getDouble("amount"));
                transaction.setTransactionDate(resultSet.getDate("date"));
                list.add(transaction);
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
            statement = connection.prepareStatement(sql);
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
