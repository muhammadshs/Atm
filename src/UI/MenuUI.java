package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame implements ActionListener {
    JRadioButton jRadioButtonInventory,jRadioButtonWithdraw,jRadioButtonDeposit,jRadioButtonLast10Transaction,jRadioButtonExit;
   ButtonGroup buttonGroup;
   JTextField jTextFieldDeposit,jTextFieldWithdraw;
    JButton jButtonSubmit;
    public MenuUI() throws HeadlessException {
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
        setVisible(true);
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
    }
}
