package UI;

import dao.TransactionDao;
import dao.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame implements ActionListener {
    String accountNumber;
    JRadioButton jRadioButtonInventory,jRadioButtonWithdraw,jRadioButtonDeposit,jRadioButtonLast10Transaction,jRadioButtonExit;
   ButtonGroup buttonGroup;
   JTextField jTextFieldDeposit,jTextFieldWithdraw;
    JButton jButtonSubmit;
    double balance,minBalance;
    TransactionDao transactionDao;
    UserDao userDao;
    public MenuUI(String accountNumber) throws HeadlessException {
        this.accountNumber=accountNumber;
        userDao=new UserDao();
        transactionDao = new TransactionDao();
        setTitle("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(600,200,400,400);
        Container container=getContentPane();
        container.setBackground(Color.pink);
        init();
        container.add(jRadioButtonInventory);
        container.add(jButtonSubmit);
        container.add(jRadioButtonDeposit);
        container.add(jRadioButtonExit);
        container.add(jRadioButtonWithdraw);
        container.add(jRadioButtonLast10Transaction);
        container.add(jTextFieldDeposit);
        container.add(jTextFieldWithdraw);
        setLayout(null);

    }
    private void init(){
        buttonGroup=new ButtonGroup();
        jRadioButtonInventory=new JRadioButton("1.Inventory");
        jRadioButtonDeposit=new JRadioButton("2.Deposit");
        jRadioButtonWithdraw=new JRadioButton("3.WithDraw");
        jRadioButtonLast10Transaction=new JRadioButton("4.Last10Transaction");
        jRadioButtonExit=new JRadioButton("5.Exit");
        jButtonSubmit=new JButton("Submit");
        jTextFieldDeposit=new JTextField();
        jTextFieldWithdraw=new JTextField();

        jRadioButtonInventory.setBounds(100,50,200,35);
        jRadioButtonDeposit.setBounds(100,100,200,35);
        jRadioButtonWithdraw.setBounds(100,150,200,35);
        jRadioButtonLast10Transaction.setBounds(100,200,200,35);
        jRadioButtonExit.setBounds(100,250,200,35);
        jButtonSubmit.setBounds(150,300,100,40);
        buttonGroup.add(jRadioButtonInventory);
        buttonGroup.add(jRadioButtonExit);
        buttonGroup.add(jRadioButtonDeposit);
        buttonGroup.add(jRadioButtonWithdraw);
        buttonGroup.add(jRadioButtonLast10Transaction);
        jTextFieldDeposit.setBounds(210,100,100,35);
        jTextFieldWithdraw.setBounds(210,150,100,35);
        jTextFieldWithdraw.setVisible(false);
        jTextFieldDeposit.setVisible(false);
        jRadioButtonWithdraw.addActionListener(this);
        jRadioButtonDeposit.addActionListener(this);
        jRadioButtonLast10Transaction.addActionListener(this);
        jRadioButtonInventory.addActionListener(this);
        jRadioButtonExit.addActionListener(this);
        jButtonSubmit.addActionListener(this);

        //----------------------------------------------------------------
        //---------------------این رو نمیدونستم چجوری بزارم توی dao ------------------------------
        double[] doubles=userDao.getAccDao().selectAcc(accountNumber);
        balance=doubles[0];
        minBalance=doubles[1];
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(jRadioButtonWithdraw.isSelected()){
            jRadioButtonWithdraw.setBounds(100,150,100,35);
            jTextFieldWithdraw.setVisible(true);
            jTextFieldDeposit.setVisible(false);
            jRadioButtonDeposit.setBounds(100,100,200,35);

        }
        if(jRadioButtonDeposit.isSelected()){
            jRadioButtonDeposit.setBounds(100,100,100,35);
            jTextFieldDeposit.setVisible(true);
            jTextFieldWithdraw.setVisible(false);
            jRadioButtonWithdraw.setBounds(100,150,200,35);
        }
        if (jRadioButtonInventory.isSelected()||jRadioButtonExit.isSelected()||jRadioButtonLast10Transaction.isSelected()){
            jTextFieldWithdraw.setVisible(false);
            jRadioButtonWithdraw.setBounds(100,150,200,35);
            jTextFieldDeposit.setVisible(false);
            jRadioButtonDeposit.setBounds(100,100,200,35);
        }
        if (e.getSource()==jButtonSubmit){
            if(jRadioButtonWithdraw.isSelected()){
                double d=Double.parseDouble(jTextFieldWithdraw.getText().trim());
                if(balance-minBalance>=d){
                    balance=balance-d;
                    userDao.getAccDao().insertDB(balance,accountNumber);
                    transactionDao.insertTransaction(TypeTransaction.withdraw,d,getAccountNumber());
                    InfoUI infoUI=new InfoUI(3,balance);
                    this.setVisible(false);
                }
            }
            if (jRadioButtonInventory.isSelected()){
                InfoUI infoUI=new InfoUI(1,balance);
                this.setVisible(false);
            }
            if (jRadioButtonDeposit.isSelected()){
                Double d=Double.parseDouble(jTextFieldDeposit.getText().trim());
                //System.out.println(d);
                if(balance-minBalance>=d){
                    balance=balance+d;
                    userDao.getAccDao().insertDB(balance,accountNumber);
                    transactionDao.insertTransaction(TypeTransaction.deposit,d,getAccountNumber());
                    InfoUI infoUI=new InfoUI(2,balance);
                    this.setVisible(false);

                }
            }
            if (jRadioButtonLast10Transaction.isSelected()){
                TransactionListUI transactionListUI=new TransactionListUI(accountNumber);
                this.setVisible(false);
            }
            if (jRadioButtonExit.isSelected()){
                InfoUI infoUI=new InfoUI(5,balance);
                this.setVisible(false);
            }
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }



}
