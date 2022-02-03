package service;

import UI.LoginUI;
import UI.MenuUI;
import dao.UserDao;

public class LoginService {

    UserDao dao;

    public LoginService() {

        dao=new UserDao();
    }

    public String login(String userName,String passWord){
        if (dao.checkLogin(userName,passWord)){
            return dao.getAccNumber();

        }
        return "";
    }

}
