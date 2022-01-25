package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTCreate {
    private static Connection connection;
    static {
        connection=DBConnector.getConnect();
    }
    public DBTCreate() {

        createTableAcc();
        createTableUser();
        createTableTransaction();
    }

    private  void createTableUser(){

        String sqlS= """
                    SELECT 1 FROM information_schema.tables WHERE 
                           ( table_schema = 'public'
                       AND    table_name   = 'user'
                       );
                    """;
        String sql= """
                      CREATE TABLE public.user
                             (
                                 id serial NOT NULL,
                                 username character(30) NOT NULL,
                                 password character(30) NOT NULL,
                                 accountnumber character(30) NOT NULL,
                                 PRIMARY KEY (id),
                                 CONSTRAINT acck FOREIGN KEY (accountnumber)
                                     REFERENCES public.account (accountnumber) MATCH SIMPLE
                                     ON UPDATE NO ACTION
                                     ON DELETE NO ACTION
                                     NOT VALID
                             );
                             
                             ALTER TABLE IF EXISTS public."user"
                                 OWNER to postgres;
                    """;
        try {
            Statement statementS=connection.createStatement();
            ResultSet resultSet=statementS.executeQuery(sqlS);
            //System.out.println(resultSet.next());
            if(!resultSet.next()) {
                Statement statement =connection.createStatement();
                statement.executeUpdate(sql);
                insertFirstUser();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //-------------------------------------------------------------------------------------
    private  void insertFirstUser(){
        String sql="INSERT INTO public.user(username,password,accountnumber) VALUES ('shah','1379','0023577541')";
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //-------------------------------------------------------------------------------------
    private  void createTableAcc() {
        String sqlS= """
                    SELECT 1 FROM information_schema.tables WHERE 
                           ( table_schema = 'public'
                       AND    table_name   = 'account'
                       );
                    """;
        String sql = """
    create table account
    (
        id           serial
            primary key,
        accountnumber char(30)         not null
            constraint niu
                unique,
        balance      double precision not null,
        minbalance   double precision not null
    );
    
    alter table account
        owner to postgres;
""";

        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sqlS);
            //System.out.println(resultSet.next());
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
    private void insertFirstAcc() {
        String sql = "INSERT INTO public.account(accountnumber,balance,minbalance) VALUES ('0023577541',10000,100)";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------------------
    private  void createTableTransaction() {
        String sqlS= """
                    SELECT 1 FROM information_schema.tables WHERE 
                           ( table_schema = 'public'
                       AND    table_name   = 'transaction'
                       );
                    """;
        String sql = """
    CREATE TABLE public.transaction
                          (
                              id serial NOT NULL,
                              type character varying(40) NOT NULL,
                              amount double precision NOT NULL,
                              date date NOT NULL,
                              account_number character(30) NOT NULL,
                              PRIMARY KEY (id)
                          );
                          
                          ALTER TABLE IF EXISTS public.transaction
                              OWNER to postgres;
""";

        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sqlS);
            //System.out.println(resultSet.next());
            if(!resultSet.next()){
                Statement statement2 = DBConnector.getConnect().createStatement();
                statement2.executeUpdate(sql);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //--------------------------------------------------------------------

}
