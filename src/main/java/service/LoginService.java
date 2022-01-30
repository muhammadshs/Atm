package service;

import UI.LoginUI;
import UI.MenuUI;
import dao.UserDao;

public class LoginService {
    private static MenuUI menuUI=null;
    LoginUI loginUI;
    UserDao dao;

    public LoginService(LoginUI loginUI) {
        this.loginUI = loginUI;
        dao=new UserDao();
    }

    public void login(String userName,String passWord){
        if (dao.checkLogin(userName,passWord)){
            menuUI=new MenuUI(dao.getAccNumber());
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
