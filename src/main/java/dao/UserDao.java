package dao;

import java.sql.*;

public class UserDao {

    AccDao accDao=null;
    private static Connection connectionS;

    public UserDao() {
        this.accDao = new AccDao();

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

    //------------------------------------------------------------------------

    //-------------------------------------------------------------------------

    //-----------------------------------------------------------------------



    public AccDao getAccDao() {
        return accDao;
    }
}
