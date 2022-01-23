package dao;

import java.sql.*;

public class AccDao {
    String accNumber;
    Connection connection;
    public AccDao(){
        connection=DBConnector.getConnect();
    }
    public void insertDB(double d, String accNumber) {
        String sql = "UPDATE public.account SET balance=? WHERE acountNumber=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, d);
            statement.setString(2, accNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void createTableAcc() {
        String sqlS="SELECT 1 FROM public.account ";
        String sql = """
    create table account
    (
        id           serial
            primary key,
        acountnumber char(30)         not null
            constraint niu
                unique,
        balance      double precision not null,
        minbalance   double precision not null
    );
    
    alter table account
        owner to postgres;
""";

        try {
            Statement statement=DBConnector.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(sqlS);
            if(!resultSet.next()){
                Statement statement2 = DBConnector.getConnect().createStatement();
                statement2.executeUpdate(sql);
                insertFirstAcc();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //--------------------------------------------------------------------
    public static void insertFirstAcc() {
        String sql = "INSERT INTO public.user (acountnumber,balance,minbalance) VALUES ('0023577541',10000,100)";
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
