package dao;

import java.sql.*;

public class AccDao {
    String accNumber;
    private static Connection connection;
    static {
        connection=DBConnector.getConnect();

    }
    public AccDao(String accNumber){
        this.accNumber=accNumber;
    }
    public void insertDB(double d, String accNumber) {
        String sql = "UPDATE public.account SET balance=? WHERE accountNumber=?";
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




    //-----------------------------------------------------------------------
    /*public String getAccNumber() {
        return accNumber;
    }*/
    //-------------------------------------------------------------------------

   /* public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }*/

    //-------------------------------------------------------
    public double[] selectAcc(String accNumber) {

        String sqlS = "Select balance,minbalance FROM public.account WHERE accountnumber=?";
        double[] d = new double[2];
        try {

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
