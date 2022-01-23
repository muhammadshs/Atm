package dao;

import java.sql.*;

public class UserDao {

    AccDao accDao=null;
    private static Connection connectionS;
    public UserDao() {
        this.accDao = new AccDao();
        createTableUser();
    }
    static {
        connectionS = DBConnector.getConnect();
    }

    public boolean checkLogin(String name,String passWord){

        String sql="SELECT accountnumber FROM public.user WHERE (username=? and password=?)";

        try {
            PreparedStatement preparedStatement=connectionS.prepareStatement(sql);
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
    private void createTableUser(){
        createDB();
        AccDao.createTableAcc();
        String sqlS="SELECT 1 FROM public.user;";
        String sql= """
                       create table "user"
                       (
                           id            integer  not null
                               primary key,
                           username      char(30) not null,
                           password      char(30) not null,
                           accountnumber char(40) not null
                               constraint um
                                   unique
                               constraint accountnumber
                                   references account (acountnumber)
                       );
                       
                       alter table "user"
                           owner to postgres;
                        
                    """;
        try {
            Statement statementS=connectionS.createStatement();
            ResultSet resultSet=statementS.executeQuery(sqlS);
            if(!resultSet.next()) {
                Statement statement = DBConnector.getConnect().createStatement();
                statement.executeUpdate(sql);
                insertFirstUser();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //------------------------------------------------------------------------
    public void insertFirstUser(){
        String sql="INSERT INTO user (username,password,accountnumber) VALUES ('shah','1379','0023577541')";
        try {
            Statement statement=connectionS.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //-------------------------------------------------------------------------

    //-----------------------------------------------------------------------

    private void createDB(){
        String sqlS="SELECT 1 FROM pg_database WHERE datname='atm_db' ";
        String sql="CREATE DATABASE atm_db";
        try {
            Statement statement=connectionS.createStatement();
            //
            ResultSet resultSet=statement.executeQuery(sqlS);
            if (!resultSet.next()){
                Statement statement2=DBConnector.getConnect().createStatement();
                statement2.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AccDao getAccDao() {
        return accDao;
    }
}
