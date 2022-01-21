package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TransactionListUI extends JFrame {
    JTable jtable;
    public TransactionListUI() throws HeadlessException {
        setTitle("last 10 transaction");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(600,100,600,600);
        Container container = getContentPane();
        container.setLayout(null);
        init();
        setVisible(true);

    }
    private void init(){
        DefaultTableModel defaultTableModel= new DefaultTableModel();
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("TYPE");
        defaultTableModel.addColumn("AMOUNT");
        defaultTableModel.addColumn("DATE");

    }
}
