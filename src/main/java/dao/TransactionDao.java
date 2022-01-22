package dao;

import DB.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionDao {
    public ArrayList<Object[]> getTransaction(String accNumber) {
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

}
