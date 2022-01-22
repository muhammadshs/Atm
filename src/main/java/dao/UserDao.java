package dao;

import DB.DBConnector;

import java.sql.*;

public class UserDao {
    AccDao accDao=new AccDao();
    public boolean checkLogin(String name,String passWord){
        String sql="SELECT accountnumber FROM public.user WHERE (username=? and password=?)";
        Connection connection= DBConnector.getConnect();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,passWord);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                accDao.setAccNumber(resultSet.getString("accountnumber"));
                return true;


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
    //--------------------------------------------------------------------
    public void createTableUser(){
        createDB();
        AccDao.createTableAcc();
        String sql="CREATE TABLE IF NOT EXISTS schemas.public.user \n" +
                "(\n" +
                "    id            integer  not null\n" +
                "        primary key,\n" +
                "    username      char(30) not null,\n" +
                "    password      char(30) not null,\n" +
                "    accountnumber char(40) not null\n" +
                "        constraint um\n" +
                "            unique\n" +
                "        constraint accountnumber\n" +
                "            references account (acountnumber)\n" +
                ");\n" +
                "\n" +
                "alter table \"user\"\n" +
                "    owner to postgres; ";
        try {
            Statement statement=DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        insertFirstUser();
    }
    //------------------------------------------------------------------------
    public void insertFirstUser(){
        String sql="INSERT INTO user (username,password,accountnumber) VALUES ('shah','1379','0023577541')";
        try {
            Statement statement=DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //-------------------------------------------------------------------------

    //-----------------------------------------------------------------------

    public void createDB(){
        String sql="CREATE DATABASE IF NOT EXISTS atm_db ;";
        try {
            Statement statement=DBConnector.getConnect().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AccDao getAccDao() {
        return accDao;
    }
}
