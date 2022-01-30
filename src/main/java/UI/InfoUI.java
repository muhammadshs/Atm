package UI;

import controller.InfoController;
import enum_pac.PageEnum;
import model.Back;
import service.InfoServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoUI extends JFrame  {
    JLabel jLabel;

    JButton jButtonBack;
    InfoController infoController;
    public InfoUI(int i, double balance) throws HeadlessException {
        setTitle("Info");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(600, 200, 400, 400);
        Container container = getContentPane();
        infoController =new InfoController(i,balance);
        init();


        container.add(jLabel);
        container.add(jButtonBack);
        container.setLayout(null);
        setVisible(true);
        InfoServices.exit(i);


    }

    private void init() {
        jLabel = infoController.jLabelSet();
        jLabel.setBounds(100, 50, 200, 200);
        jButtonBack =new JButton("Back");
        jButtonBack.setBounds(20,10,70,30);

        jButtonBack.addActionListener(infoController);
    }





}
