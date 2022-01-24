package dao;

import java.sql.*;

public class DBConnector {
    private static final DBConnector dbConnector = new DBConnector();
    private static Connection conn = null;
    private static Connection postConn=null;
    private DBConnector() {
    }

    public static DBConnector getInstance() {

        return dbConnector;

    }

    static {
        try {
            conn = DriverManager.getConnection(DBConfig.DBURL, DBConfig.DBUSER, DBConfig.DBPASS);
            postConn=DriverManager.getConnection(DBConfig.POSTURL,DBConfig.DBUSER,DBConfig.DBPASS);

        } catch (SQLException e) {
            System.err.println("cant connect to DB ");
            e.printStackTrace();
        }
    }

    public static Connection getConnect() {

        return conn;
    }
    public static Connection getPostConn(){
        return postConn;
    }

}
