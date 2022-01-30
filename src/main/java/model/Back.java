package model;

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
                    LoginService.setVisibilityMenu(true);

                }
                else if(pageEnum==info){
                    //---------------------------------------- این قسمت رو نگاه کنید
                    MenuService.setVisiblityInfo(false);
                    LoginService.setVisibilityMenu(true);
            }
                break;


        }
    }

    public static void setBack(PageEnum setBack) {
        backList.push(setBack);
    }
}
