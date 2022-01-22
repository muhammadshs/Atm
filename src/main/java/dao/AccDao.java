package dao;

import DB.DBConnector;

import java.sql.*;

public class AccDao {
    String accNumber;

    public void insertDB(double d, String accNumber) {
        String sql = "UPDATE public.account SET balance=? WHERE acountNumber=?";
        PreparedStatement statement = null;
        try {
            statement = DBConnector.getConnect().prepareStatement(sql);
            statement.setDouble(1, d);
            statement.setString(2, accNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void createTableAcc() {
        String sql = "create table IF NOT EXISTS schemas.public.account  \n" +
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
            Statement statement = DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        insertFirstAcc();
    }

    //--------------------------------------------------------------------
    public static void insertFirstAcc() {
        String sql = "INSERT INTO user (acountnumber,balance,minbalance) VALUES ('0023577541',10000,100)";
        try {
            Statement statement = DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-----------------------------------------------------------------------
    public String getAccNumber() {
        return accNumber;
    }
    //-------------------------------------------------------------------------

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    //-------------------------------------------------------
    public double[] selectAcc(String accNumber) {
        String sqlS = "Select balance,minbalance FROM public.account WHERE acountnumber=?";
        double[] d = new double[2];
        try {
            Connection connection = DBConnector.getConnect();
            PreparedStatement statement = connection.prepareStatement(sqlS);
            statement.setString(1, accNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                d[0] = resultSet.getDouble("balance");
                d[1] = resultSet.getDouble("minbalance");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return d;
    }

}
