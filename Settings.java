package NQueens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings {
    static class settingsFrame extends JFrame {
        settingsFrame(){
            JLabel l1= new JLabel("Set Board Size: ");
            JTextField text= new JTextField(10);
            JButton btn= new JButton("Run");

            add(l1);
            add(text);
            add(btn);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String n= text.getText();

                    String[] args= {n};
                    nQueens2.main(args);
                }
            });

            setVisible(true);
            setSize(500,500);
            setLayout(new FlowLayout());
            setTitle("N Queens Visualization");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        settingsFrame obj= new settingsFrame();
    }
}
