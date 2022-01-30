package controller;

import UI.LoginUI;
import service.LoginService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginController implements ActionListener {
    private JTextField userName,passWord;
    LoginUI loginUI;
    private LoginService loginService;
    public LoginController(JTextField userName, JTextField passWord, LoginUI loginUI) {
       loginService=new LoginService(loginUI);
        this.loginUI=loginUI;
        this.userName=userName;
        this.passWord=passWord;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loginService.login(userName.getText(),passWord.getText());

    }

}
