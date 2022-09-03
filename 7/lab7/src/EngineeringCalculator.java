import javax.swing.*;
import java.awt.*;

public class EngineeringCalculator {

    JFrame calcFrame;

    public EngineeringCalculator() {
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
        keyboardPanel.setSize(200,250);
        keyboardPanel.setLocation(75, 200);
        keyboardPanel.setLayout(new GridLayout(6,4));
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

        JButton sinBtn = new JButton();
        sinBtn.setText("sin");
        keyboardPanel.add(sinBtn);

        JButton cosBtn = new JButton();
        cosBtn.setText("cos");
        keyboardPanel.add(cosBtn);

        JButton logBtn = new JButton();
        logBtn.setText("log");
        keyboardPanel.add(logBtn);

        JButton piBtn = new JButton();
        piBtn.setText("π");
        keyboardPanel.add(piBtn);


        JButton shift = new JButton();
        shift.setText("shf");
        keyboardPanel.add(shift);

    }


    public void Screen(){
        JTextArea display = new JTextArea();
        display.setEditable(false);
        display.setFont(new Font("Arial", 14,14));

        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setSize(200, 100);
        scrollPane.setLocation(75,40);
        calcFrame.getContentPane().add(scrollPane);

    }


}
