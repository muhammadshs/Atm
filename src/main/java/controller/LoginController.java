package controller;

import UI.LoginUI;
import UI.MenuUI;
import service.LoginService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginController implements ActionListener {
    private JTextField userName,passWord;
    LoginUI loginUI;
    private static MenuUI menuUI=null;

    private LoginService loginService;
    public LoginController(JTextField userName, JTextField passWord, LoginUI loginUI) {
       loginService=new LoginService();
        this.loginUI=loginUI;
        this.userName=userName;
        this.passWord=passWord;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accountNum=loginService.login(userName.getText(),passWord.getText());
        if(!accountNum.equals("")){
            menuUI=new MenuUI(accountNum);
            getMenuUI().setVisible(true);
            loginUI.setVisible(false);
        }

    }
    public static MenuUI getMenuUI(){
        return menuUI;
    }

    public static void setVisibilityMenu(boolean visibilityMenu){
        menuUI.setVisible(visibilityMenu);

    }

}
