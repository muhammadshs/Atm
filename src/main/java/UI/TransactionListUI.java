package UI;

import DB.DBConnector;
import dao.TransactionDao;
import objects.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransactionListUI extends JFrame {
    JTable jtable;
    String accountNumber;
    ArrayList<Object[]> list;
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
        container.add(jtable);
        setVisible(true);

    }
    private void init(){
        DefaultTableModel defaultTableModel= new DefaultTableModel();
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("TYPE");
        defaultTableModel.addColumn("AMOUNT");
        defaultTableModel.addColumn("DATE");
        TransactionDao transactionDao=new TransactionDao();
            list=transactionDao.getTransaction(accountNumber);


            for (int i=0;i<list.size();i++){
                defaultTableModel.addRow(list.get(i));
            }

        jtable=new JTable(defaultTableModel);
        jtable.setBounds(50,25,500,500);

    }
}
