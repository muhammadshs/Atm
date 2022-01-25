package UI;

import dao.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame implements ActionListener {
    UserDao dao;
    private static MenuUI menuUI=null;
    JLabel jLabelUserName,jLabelPassWord;
    JTextField jTextFieldName,jTextFieldPassWord;
    JButton jButton;
    public LoginUI() throws HeadlessException {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(600,200,400,400);
        dao=new UserDao();
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


                if (dao.checkLogin(jTextFieldName.getText(),jTextFieldPassWord.getText())){
                    menuUI=new MenuUI(dao.getAccNumber());
                    getMenuUI().setVisible(true);
                    this.setVisible(false);
                }


    }
    public static MenuUI getMenuUI(){
        return menuUI;
    }

    public static void setVisiblityMenu(boolean visiblityMenu){
        menuUI.setVisible(visiblityMenu);

    }


}
