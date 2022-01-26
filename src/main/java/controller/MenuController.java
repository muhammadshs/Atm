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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    JRadioButton jRadioButtonInventory, jRadioButtonWithdraw, jRadioButtonDeposit, jRadioButtonLast10Transaction, jRadioButtonExit;
    JTextField jTextFieldDeposit, jTextFieldWithdraw;
    JButton jButtonSubmit;
    AccDao accDao;
    double balance, minBalance;
    String accountNumber;
    TransactionDao transactionDao;
    private static InfoUI infoUI;
    MenuUI menuUI;
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
        this.menuUI=menuUI;
        transactionDao = new TransactionDao();
        accDao = new AccDao();
        double[] doubles = accDao.selectAcc(accountNumber);
        balance = doubles[0];
        minBalance = doubles[1];
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
                double d= Validation.valDouble(jTextFieldWithdraw.getText().trim());
                if(balance-minBalance>=d){
                    balance=balance-d;
                    accDao.insertDB(balance,accountNumber);
                    transactionDao.insertTransaction(TypeTransaction.withdraw,d,getAccountNumber());
                    infoUI=new InfoUI(3,balance);
                    Back.setBack(PageEnum.menu);
                    menuUI.setVisible(false);
                }
            }
            if (jRadioButtonInventory.isSelected()){
                infoUI=new InfoUI(1,balance);
                Back.setBack(PageEnum.menu);
                menuUI.setVisible(false);
            }
            if (jRadioButtonDeposit.isSelected()){
                Double d= Validation.valDouble(jTextFieldDeposit.getText().trim());
                //System.out.println(d);
                if(balance-minBalance>=d){
                    balance=balance+d;
                    accDao.insertDB(balance,accountNumber);
                    transactionDao.insertTransaction(TypeTransaction.deposit,d,getAccountNumber());
                    infoUI=new InfoUI(2,balance);
                    Back.setBack(PageEnum.menu);
                    menuUI.setVisible(false);

                }
            }
            if (jRadioButtonLast10Transaction.isSelected()){
                TransactionListUI transactionListUI=new TransactionListUI(accountNumber);
                Back.setBack(PageEnum.menu);
                menuUI.setVisible(false);
            }
            if (jRadioButtonExit.isSelected()){
                infoUI=new InfoUI(5,balance);
                Back.setBack(PageEnum.menu);
                menuUI.setVisible(false);
            }
        }
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static void setVisiblityInfo(boolean visiblityInfo) {
        infoUI.setVisible(visiblityInfo);
    }

}
