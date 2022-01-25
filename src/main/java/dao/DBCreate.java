package dao;

import java.sql.*;

public class DBCreate {
    private static Connection postConn=null;
    public DBCreate() {
        String sqlS="SELECT 1 FROM pg_database WHERE datname='atm_db' ";
        String sql="CREATE DATABASE atm_db";
        try {
            Statement statement=getPostConn().createStatement();
            //
            ResultSet resultSet=statement.executeQuery(sqlS);
            if (!resultSet.next()){
                Statement statement2=getPostConn().createStatement();
                statement2.executeUpdate(sql);
            }
            else{
                System.out.println("have db");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBTCreate dbtCreate=new DBTCreate();
    }
    static {
        try {
            postConn= DriverManager.getConnection(DBConfig.POSTURL,DBConfig.DBUSER,DBConfig.DBPASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Connection getPostConn(){
        return postConn;
    }
}
