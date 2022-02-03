package model;

import controller.LoginController;
import controller.MenuController;
import enum_pac.PageEnum;
import service.LoginService;
import service.MenuService;

import java.util.Stack;

import static enum_pac.PageEnum.info;
import static enum_pac.PageEnum.transaction;

public class Back {
    private static Stack<PageEnum> backList;
    private Back(){

    }

    static {
        backList=new Stack<>();
    }
    public static void getBack(PageEnum pageEnum) {
        PageEnum en=backList.pop();
        switch (en){
            case menu :
                if(pageEnum== transaction) {
                    LoginController.setVisibilityMenu(true);

                }
                else if(pageEnum==info){
                    //---------------------------------------- این قسمت رو نگاه کنید
                    MenuController.setVisiblityInfo(false);
                    LoginController.setVisibilityMenu(true);
            }
                break;


        }
    }

    public static void setBack(PageEnum setBack) {
        backList.push(setBack);
    }
}
