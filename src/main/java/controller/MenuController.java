package controller;

import UI.InfoUI;
import UI.MenuUI;
import UI.TransactionListUI;
import dao.AccDao;
import dao.TransactionDao;
import enum_pac.PageEnum;
import enum_pac.TypeTransaction;
import input.Validation;
import model.Back;
import service.MenuService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    JRadioButton jRadioButtonInventory, jRadioButtonWithdraw, jRadioButtonDeposit, jRadioButtonLast10Transaction, jRadioButtonExit;
    JTextField jTextFieldDeposit, jTextFieldWithdraw;
    JButton jButtonSubmit;


    String accountNumber;
    private MenuService menuService;


    public MenuController(JRadioButton jRadioButtonInventory, JRadioButton jRadioButtonWithdraw, JRadioButton jRadioButtonDeposit, JRadioButton jRadioButtonLast10Transaction, JRadioButton jRadioButtonExit, JTextField jTextFieldDeposit, JTextField jTextFieldWithdraw, JButton jButtonSubmit, MenuUI menuUI,String accNumber) {
        this.jButtonSubmit=jButtonSubmit;
        this.jRadioButtonInventory = jRadioButtonInventory;
        this.jRadioButtonWithdraw = jRadioButtonWithdraw;
        this.jRadioButtonDeposit = jRadioButtonDeposit;
        this.jRadioButtonLast10Transaction = jRadioButtonLast10Transaction;
        this.jRadioButtonExit = jRadioButtonExit;
        this.jTextFieldDeposit = jTextFieldDeposit;
        this.jTextFieldWithdraw = jTextFieldWithdraw;
        this.accountNumber = accNumber;

        menuService=new MenuService(accountNumber,menuUI);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(jRadioButtonWithdraw.isSelected()){
            jRadioButtonWithdraw.setBounds(100,150,100,35);
            jTextFieldWithdraw.setVisible(true);
            jTextFieldDeposit.setVisible(false);
            jRadioButtonDeposit.setBounds(100,100,200,35);
            jTextFieldDeposit.setText("");

        }
        if(jRadioButtonDeposit.isSelected()){
            jRadioButtonDeposit.setBounds(100,100,100,35);
            jTextFieldDeposit.setVisible(true);
            jTextFieldWithdraw.setVisible(false);
            jRadioButtonWithdraw.setBounds(100,150,200,35);
            jTextFieldWithdraw.setText("");
        }
        if (jRadioButtonInventory.isSelected()||jRadioButtonExit.isSelected()||jRadioButtonLast10Transaction.isSelected()){
            jTextFieldWithdraw.setVisible(false);
            jRadioButtonWithdraw.setBounds(100,150,200,35);
            jTextFieldDeposit.setVisible(false);
            jRadioButtonDeposit.setBounds(100,100,200,35);
            jTextFieldWithdraw.setText("");
            jTextFieldDeposit.setText("");
        }
        if (e.getSource()==jButtonSubmit){
            if(jRadioButtonWithdraw.isSelected()){
                menuService.withDraw(jTextFieldWithdraw.getText());
            }
            if (jRadioButtonInventory.isSelected()){
               menuService.inventory();
            }
            if (jRadioButtonDeposit.isSelected()){
               menuService.deposit(jTextFieldDeposit.getText());
            }
            if (jRadioButtonLast10Transaction.isSelected()){
                menuService.last10Transaction();
            }
            if (jRadioButtonExit.isSelected()){
                menuService.exit();
            }
        }
    }


}
