package UI;

import DB.DBConnector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginUI extends JFrame implements ActionListener {

    private static MenuUI menuUI=null;
    JLabel jLabelUserName,jLabelPassWord;
    JTextField jTextFieldName,jTextFieldPassWord;
    JButton jButton;
    public LoginUI() throws HeadlessException {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(600,200,400,400);
        Container container=getContentPane();
        container.setBackground(Color.pink);
        init();
        jButton.addActionListener(this);
        container.setLayout(null);
        container.add(jLabelUserName);
        container.add(jTextFieldName);
        container.add(jLabelPassWord);
        container.add(jTextFieldPassWord);
        container.add(jButton);

        setVisible(true);
    }
    private void init(){
        jLabelUserName=new JLabel("UserName :");
        jLabelPassWord=new JLabel("PassWord :");
        jTextFieldName=new JTextField();
        jTextFieldPassWord=new JTextField();
        jButton=new JButton("Login");

        jTextFieldName.setBounds(100,100,200,40);
        jLabelUserName.setBounds(100,50,200,30);
        jLabelPassWord.setBounds(100,150,200,30);
        jTextFieldPassWord.setBounds(100,200,200,40);
        jButton.setBounds(150,270,100,40);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Connection connection= DBConnector.getConnect();
        String sqlC="CREATE TABLE public.user IF NOT EXIST";
        String sql="SELECT accountnumber FROM public.user WHERE (username=? and password=?)";
        try {
            Statement preparedStatement2=connection.prepareStatement(sqlC);

            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,jTextFieldName.getText());
            preparedStatement.setString(2,jTextFieldPassWord.getText());
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                menuUI=new MenuUI(resultSet.getString("accountnumber"));

                getMenuUI().setVisible(true);
                this.setVisible(false);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static MenuUI getMenuUI(){
        return menuUI;
    }


}
