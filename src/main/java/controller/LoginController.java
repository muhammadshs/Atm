package controller;

import UI.LoginUI;
import UI.MenuUI;
import dao.UserDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginController implements ActionListener {
    private JTextField userName,passWord;
    UserDao dao;
    private static MenuUI menuUI=null;
    LoginUI loginUI;
    public LoginController(JTextField userName, JTextField passWord, LoginUI loginUI) {
        dao=new UserDao();
        this.loginUI=loginUI;
        this.userName=userName;
        this.passWord=passWord;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (dao.checkLogin(userName.getText(),passWord.getText())){
            menuUI=new MenuUI(dao.getAccNumber());
            getMenuUI().setVisible(true);
            loginUI.setVisible(false);

        }

    }
    public static MenuUI getMenuUI(){
        return menuUI;
    }

    public static void setVisiblityMenu(boolean visiblityMenu){
        menuUI.setVisible(visiblityMenu);

    }
}
