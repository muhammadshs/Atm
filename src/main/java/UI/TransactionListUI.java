package UI;

import dao.TransactionDao;
import enum_pac.PageEnum;
import model.Back;
import model.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TransactionListUI extends JFrame implements ActionListener {
    JTable jtable;
    String accountNumber;
    ArrayList<Transaction> list;
    JButton jButton;

    public TransactionListUI(String accountNumber) throws HeadlessException {
        list=new ArrayList<>();
        this.accountNumber=accountNumber;
        setTitle("last 10 transaction");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(600,100,600,600);
        Container container = getContentPane();

        container.setLayout(null);
        init();
        container.add(jButton);
        container.add(jtable);
        setVisible(true);


    }
    private void init(){
        jButton=new JButton("Back");
        jButton.addActionListener(this);
        jButton.setBounds(20,10,70,30);

        DefaultTableModel defaultTableModel= new DefaultTableModel();
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("TYPE");
        defaultTableModel.addColumn("AMOUNT");
        defaultTableModel.addColumn("DATE");
        TransactionDao transactionDao=new TransactionDao();
        list=transactionDao.getTransaction(accountNumber);


            for (int i=0;i<list.size();i++){
                defaultTableModel.addRow(new Object[]{list.get(i).getId(),list.get(i).getTypeTransaction(),list.get(i).getTransactionAmount(),list.get(i).getTransactionDate()});
            }

        jtable=new JTable(defaultTableModel);
        jtable.setBounds(75,50,450,450);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Back.getBack(PageEnum.transaction);
        this.setVisible(false);
    }



}
