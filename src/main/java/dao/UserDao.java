package dao;

import java.sql.*;

public class UserDao extends DaoImp{



    private String accNumber;
    public UserDao() {


    }




    public boolean checkLogin(String name,String passWord){

        String sql="SELECT accountnumber FROM public.user WHERE (username=? and password=?)";

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,passWord);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                accNumber=resultSet.getString("accountnumber");
                return true;


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
    //--------------------------------------------------------------------

    //------------------------------------------------------------------------

    //-------------------------------------------------------------------------

    //-----------------------------------------------------------------------

    public String getAccNumber() {
        return accNumber;
    }


    //public AccDao getAccDao() {
     //   return accDao;
    //}
}
