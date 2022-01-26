package dao;

import java.sql.Connection;

public abstract class DaoImp implements Dao{
    protected static Connection connection;
    static {
        connection=DBConnector.getConnect();

    }
}
