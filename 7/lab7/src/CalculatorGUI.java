import javax.swing.*;
import java.awt.*;

public class CalculatorGUI {

    JFrame calcFrame;

    public CalculatorGUI() {
        calcFrame = new JFrame();
        calcFrame.setTitle("AUT Calculator");
        calcFrame.setSize(350, 550);
        calcFrame.setLocation(100, 100);
        calcFrame.setLayout(null);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        KeyBoard();
        Screen();
        calcFrame.setVisible(true);
    }
    public void KeyBoard(){
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setSize(200,200);
        keyboardPanel.setLocation(75, 200);
        keyboardPanel.setLayout(new GridLayout(4,4));
        calcFrame.add(keyboardPanel);

        for (int i=7;i<10;i++){
            JButton btn = new JButton();
            btn.setText("" + i);
            keyboardPanel.add(btn);
        }

        JButton divisionBtn = new JButton();
        divisionBtn.setText("÷");
        keyboardPanel.add(divisionBtn);

        for (int i=4;i<7;i++){
            JButton btn = new JButton();
            btn.setText("" + i);
            keyboardPanel.add(btn);
        }

        JButton multiBtn = new JButton();
        multiBtn.setText("×");
        keyboardPanel.add(multiBtn);

        for (int i=1;i<4;i++){
            JButton btn = new JButton();
            btn.setText("" + i);
            keyboardPanel.add(btn);
        }
        JButton minesBtn = new JButton();
        minesBtn.setText("-");
        keyboardPanel.add(minesBtn);

        JButton doBtn = new JButton();
        doBtn.setText("=");
        keyboardPanel.add(doBtn);

        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        keyboardPanel.add(zeroBtn);

        JButton modBtn = new JButton();
        modBtn.setText("%");
        keyboardPanel.add(modBtn);

        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        keyboardPanel.add(sumBtn);

    }


    public void Screen(){
        JTextArea display = new JTextArea();
        display.setEditable(false);
        display.setFont(new Font("Arial", 14,14));

        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setSize(200, 100);
//        scrollPane.setPreferredSize(new Dimension(200, 100));
        scrollPane.setLocation(75,40);

//        for (int i=0; i<20; i++){
//            display.append("   " +i);
//        }
        calcFrame.getContentPane().add(scrollPane);

    }








}