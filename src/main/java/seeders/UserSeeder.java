package seeders;

import dao.DBConnector;

import java.sql.SQLException;
import java.sql.Statement;

public class UserSeeder {
    public UserSeeder() {
        insertFirstUser();
    }

    private  void insertFirstUser(){
        String sql="INSERT INTO public.user(username,password,accountnumber) VALUES ('shah','1379','0023577541')";
        try {
            Statement statement= DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
