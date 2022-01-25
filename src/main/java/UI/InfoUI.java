package UI;

import enum_pac.PageEnum;
import model.Back;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoUI extends JFrame implements ActionListener {
    JLabel jLabel;
    int i;
    double balance;
    JButton jButtonBack;
    public InfoUI(int i, double balance) throws HeadlessException {
        this.balance = balance;
        this.i = i;
        setTitle("Info");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(600, 200, 400, 400);
        Container container = getContentPane();
        init();
        setText();
        container.add(jLabel);
        container.add(jButtonBack);
        container.setLayout(null);
        setVisible(true);
        if(i==5){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);

        }

    }

    private void init() {
        jLabel = new JLabel("info");
        jLabel.setBounds(100, 50, 200, 200);
        jButtonBack =new JButton("Back");
        jButtonBack.setBounds(20,10,70,30);
        jButtonBack.addActionListener(this);
    }

    private void setText() {
        String massage;
        switch (i) {
            case 1:
                massage = "your inventory is : " + balance;
                jLabel.setText(massage);
               // System.out.println(massage);
                break;
            case 2:
                massage = "<html> Deposit is successful ----->>>> </br>  your inventory is : " + balance +"</html>";
                jLabel.setText(massage);
                //System.out.println(massage);
                break;
            case 3:
                massage = "<html> Withdraw is successful ----->>>> </br>  your inventory is : " + balance +"</html>";
                jLabel.setText(massage);
               // System.out.println(massage);
                break;
            case 5:
                jLabel.setText("See You later");
                //System.out.println("see");

                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        Back.getBack(PageEnum.info);
    }
}
