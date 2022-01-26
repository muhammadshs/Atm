package UI;

import controller.LoginController;
import dao.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {


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

        container.setLayout(null);
        container.add(jLabelUserName);
        container.add(jTextFieldName);
        container.add(jLabelPassWord);
        container.add(jTextFieldPassWord);
        container.add(jButton);
        LoginController loginController=new LoginController(jTextFieldName,jTextFieldPassWord,this);
        jButton.addActionListener(loginController);
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




}
