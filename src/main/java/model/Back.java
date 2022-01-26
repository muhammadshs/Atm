package model;

import UI.InfoUI;
import UI.LoginUI;
import UI.MenuUI;
import UI.TransactionListUI;
import controller.LoginController;
import controller.MenuController;
import enum_pac.PageEnum;

import java.util.Stack;

import static enum_pac.PageEnum.*;

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
                    LoginController.setVisiblityMenu(true);

                }
                else if(pageEnum==info){
                    MenuController.setVisiblityInfo(false);
                    LoginController.setVisiblityMenu(true);
            }
                break;


        }
    }

    public static void setBack(PageEnum setBack) {
        backList.push(setBack);
    }
}
