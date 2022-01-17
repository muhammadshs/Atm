package UI;

import javax.swing.*;
import java.awt.*;

public class InfoUI extends JFrame {
    JLabel jLabel;
    int i;
    public InfoUI(int i) throws HeadlessException {
        this.i=i;
        setTitle("Info");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(600,200,400,400);
        Container container=getContentPane();
        init();
        container.setLayout(null);
        setVisible(true);
    }
    private void init(){
        jLabel=new JLabel("info");
        jLabel.setBounds(100,50,200,300);
        switch (i){
            case 1:
                jLabel.setText("1");
                break;
            case 2:
                jLabel.setText("2");
                break;
            case 3:
                jLabel.setText("3");
                break;
            case 4:
                jLabel.setText("4");
                break;
        }
    }
}
