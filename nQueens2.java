package NQueens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class nQueens2 {
    static HashSet<Integer> leftDia;
    static HashSet<Integer> rightDia;
    static HashSet<Integer> hor;
    static HashSet<Integer> ver;
    static int n;
    static JLabel[][] jLabel;
    static int[][] board;

    static class settingsFrame extends JFrame{
        settingsFrame(){
            setVisible(true);
            setSize(500,500);
            setLayout(new FlowLayout());
            setTitle("N Queens Visualization");
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            JLabel l1= new JLabel("Set Board Size: ");
            JTextField text= new JTextField(10);
            JButton btn= new JButton("Run");

            add(l1);
            add(text);
            add(btn);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    n= Integer.parseInt( text.getText() );

                    myFrame obj= new myFrame();
                    solveNQueen(n, 0);
                }
            });
        }
    }
    static class myFrame extends JFrame{
        myFrame(){
            jLabel = new JLabel[n][n];
            board= new int[n][n];

            setVisible(true);
            setSize(500,500);
            System.out.println("n: "+ n);

            setLayout(new GridLayout(n, n, 2, 2));
            setTitle("N Queens Visualization");
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    jLabel[i][j] = new JLabel();
                    jLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);

                    jLabel[i][j].setOpaque(true);
                    jLabel[i][j].setFont(new Font("Arial", Font.BOLD, 16));
                    jLabel[i][j].setForeground(Color.WHITE);
                    jLabel[i][j].setBackground((i + j) % 2 == 0 ? Color.GRAY : Color.DARK_GRAY);

                    add(jLabel[i][j]);
                }
            }
        }
    }

    public static void main( String args[] ){
        leftDia= new HashSet<>();
        rightDia= new HashSet<>();
        hor= new HashSet<>();
        ver= new HashSet<>();

        settingsFrame obj= new settingsFrame();
    }

    public static void solveNQueen(int queens, int row){
        if(queens == 0){
            System.out.println("Printing Queen Positions: ");
            printSolution();
            return;
        }

        for(int col=0; col<n; col++){
            //Increase the sleep value to slow down the animation
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if( check(row, col) ){
                leftDia.add(row-col);
                rightDia.add(row+col);
                hor.add(row);
                ver.add(col);
                board[row][col]= 1;

                jLabel[row][col].setBackground(Color.ORANGE);

                solveNQueen(queens-1, row+1);
                jLabel[row][col].setBackground((row + col) % 2 == 0 ? Color.GRAY : Color.DARK_GRAY);

                board[row][col]= 0;
                leftDia.remove(row-col);
                rightDia.remove(row+col);
                hor.remove(row);
                ver.remove(col);
            }
        }
    }

    public static boolean check(int row, int col){
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if( !leftDia.contains(row-col) && !rightDia.contains(row+col) && !hor.contains(row) && !ver.contains(col) ){
            return true;
        }
        return false;
    }

    static void printSolution(){
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                System.out.print(board[i][j]+"\t");
            }
            System.out.printf("\n");
        }

    }
}