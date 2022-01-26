package controller;

import enum_pac.PageEnum;
import model.Back;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoController implements ActionListener {
    public InfoController(int i) {
        if(i==5){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        Back.getBack(PageEnum.info);
    }
}
