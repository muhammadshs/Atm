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
        String sqlS="SELECT 1 FROM pg_database WHERE datname='atm_db' ";
        String sql="CREATE DATABASE atm_db";
        try {
            Statement statement=DBConnector.getPostConn().createStatement();
            //
            ResultSet resultSet=statement.executeQuery(sqlS);
            if (!resultSet.next()){
                Statement statement2=DBConnector.getPostConn().createStatement();
                statement2.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createTableAcc();
        createTableUser();
    }

    private static void createTableUser(){

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
            Statement statementS=connection.createStatement();
            ResultSet resultSet=statementS.executeQuery(sqlS);
            if(!resultSet.next()) {
                Statement statement =connection.createStatement();
                statement.executeUpdate(sql);
                insertFirstUser();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private static void insertFirstUser(){
        String sql="INSERT INTO user (username,password,accountnumber) VALUES ('shah','1379','0023577541')";
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createTableAcc() {
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
            Statement statement=connection.createStatement();
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
    private static void insertFirstAcc() {
        String sql = "INSERT INTO public.user (acountnumber,balance,minbalance) VALUES ('0023577541',10000,100)";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
