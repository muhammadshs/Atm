package seeders;

import dao.DBConnector;

import java.sql.SQLException;
import java.sql.Statement;

public class AccSeeder {
    public AccSeeder() {
        insertFirstAcc();
    }

    private void insertFirstAcc() {
        String sql = "INSERT INTO public.account(accountnumber,balance,minbalance) VALUES ('0023577541',10000,100)";
        try {
            Statement statement = DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
