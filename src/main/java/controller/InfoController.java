package controller;

import enum_pac.PageEnum;
import model.Back;
import service.InfoServices;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoController implements ActionListener {
    private InfoServices infoServices;
    private JLabel jLabel;
    public InfoController(int i,double balance) {
        infoServices=new InfoServices(i,balance);


    }
    public JLabel jLabelSet(){
        jLabel=new JLabel(infoServices.setText());
        return jLabel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {


        Back.getBack(PageEnum.info);
    }
}
