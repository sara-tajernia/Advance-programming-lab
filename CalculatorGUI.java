import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI {

    private JFrame calcFrame;
    private JPanel keyboardPanel;
    private JTextArea display;
    private String sign = "";
    private String num1 = "";
    private String num2 = "";
    private String saving = "0";

    /**
     * create a JFrame with all the details
     */
    public CalculatorGUI() {
        calcFrame = new JFrame();
        calcFrame.setBackground(new Color(10, 70, 150));
        calcFrame.setTitle("AUT Calculator");
        calcFrame.setSize(350, 550);
        calcFrame.setLocationRelativeTo(null);
        calcFrame.setLayout(null);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        KeyBoard();
        Screen();
        KeyHandeling();
        addMenu();
        calcFrame.setVisible(true);
    }

    /**
     * create a menubar top of the screen and add Mnemonic to menubar and
     * Accelerator to menu item and override actionPerformed the right
     * thing by event
     */
    public void addMenu(){
        JMenuBar jmb = new JMenuBar();
        calcFrame.setJMenuBar(jmb);

        JMenu menu = new JMenu("Menu");                     //create a new Menubar
        menu.setMnemonic('M');
        jmb.add(menu);

        JMenuItem save = new JMenuItem("Save");           //create a new items on menubar
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saving = num1;                                 //save a shown number on JPanel
            }
        });
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));      //set accelerator for JMenuItem
        menu.add(save);

        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(saving);                        //set the saved number on the JPanel
            }
        });
        load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        menu.add(load);

        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionListener() {          //show the right message about program
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Amirkabir calculator", "about",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        menu.add(about);

        JMenuItem item = new JMenuItem("Exit");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);                         //exit the program
            }
        });
        menu.add(item);
    }

    /**
     * create a JPanel for show the buttons and add buttons by specific order
     */
    public void KeyBoard(){
        keyboardPanel = new JPanel(new BorderLayout(5,5));
        keyboardPanel.setSize(200,200);
        keyboardPanel.setLocation(75, 200);
        keyboardPanel.setLayout(new GridLayout(4,4));
        calcFrame.add(keyboardPanel);
        GUI handler = new GUI();

        for (int i=7;i<10;i++){                           //add the buttons in order
            JButton btn = new JButton("" + i);
            btn.setBackground(new Color(180, 50, 80));
            btn.setOpaque(true);
            btn.addActionListener(handler);               //add actionListener to respond when we click on button
            keyboardPanel.add(btn);
        }

        JButton divisionBtn = new JButton("÷");
        divisionBtn.setBackground(new Color(150, 200, 255));
        divisionBtn.setOpaque(true);
//        divisionBtn.setFocusPainted(true);

//        divisionBtn.setForeground(Color.white);
//        divisionBtn.setForeground(Color.black);
        divisionBtn.addActionListener(handler);
        divisionBtn.setToolTipText("Division");
        keyboardPanel.add(divisionBtn);

        for (int i=4;i<7;i++){
            JButton btn = new JButton("" + i);
            btn.setBackground(new Color(180, 50, 80));
            btn.setOpaque(true);
            btn.addActionListener(handler);
            keyboardPanel.add(btn);
        }

        JButton multiBtn = new JButton("×");
        multiBtn.setBackground(new Color(150, 200, 255));
        multiBtn.setOpaque(true);
        multiBtn.addActionListener(handler);
        multiBtn.setToolTipText("Multiply");
        keyboardPanel.add(multiBtn);

        for (int i=1;i<4;i++){
            JButton btn = new JButton("" + i);
            btn.setBackground(new Color(180, 50, 80));
            btn.setOpaque(true);
            btn.addActionListener(handler);
            keyboardPanel.add(btn);
        }
        JButton minesBtn = new JButton("-");
        minesBtn.setBackground(new Color(150, 200, 255));
        minesBtn.setOpaque(true);
        minesBtn.addActionListener(handler);
        minesBtn.setToolTipText("Subtraction");
        keyboardPanel.add(minesBtn);

        JButton doBtn = new JButton("=");
        doBtn.setBackground(new Color(150, 200, 255));
        doBtn.setOpaque(true);
        doBtn.addActionListener(handler);
        doBtn.setToolTipText("Equal");
        keyboardPanel.add(doBtn);

        JButton zeroBtn = new JButton("0");
        zeroBtn.setBackground(new Color(180, 50, 80));
        zeroBtn.setOpaque(true);
        zeroBtn.addActionListener(handler);
        keyboardPanel.add(zeroBtn);

        JButton modBtn = new JButton("%");
        modBtn.setBackground(new Color(150, 200, 255));
        modBtn.setOpaque(true);
        modBtn.addActionListener(handler);
        modBtn.setToolTipText("Mod");
        keyboardPanel.add(modBtn);

        JButton sumBtn = new JButton("+");
        sumBtn.setBackground(new Color(150, 200, 255));
        sumBtn.setOpaque(true);
        sumBtn.addActionListener(handler);
        sumBtn.setToolTipText("Sum");
        keyboardPanel.add(sumBtn);

    }

    /**
     * create a JTextArea for show the numbers and sign
     */
    public void Screen(){
        display = new JTextArea();
        display.setEditable(false);
        display.setFont(new Font("Arial", 35,35));
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setSize(200, 100);
        scrollPane.setLocation(75,40);
        calcFrame.getContentPane().add(scrollPane);
        display.setBackground(new Color(120, 200, 140));
    }

    /**
     * to respond we type the numbers and sign(only *(multiply) /(division) +(plus)
     *   -(minus) %(mod) =(equals) and show them on JTextArea
     */

    public void KeyHandeling(){
        calcFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
//                System.out.println("lagffgksfcwyf" +KeyEvent.VK_MODECHANGE);
                if (e.getKeyCode() == KeyEvent.VK_PLUS)
                    System.exit(0);
                if (e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_1 ||e.getKeyCode() == KeyEvent.VK_2 ||
                        e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5 ||
                        e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_8 ||
                        e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode() == KeyEvent.VK_MINUS ||
                        e.getKeyCode() == KeyEvent.VK_MULTIPLY || e.getKeyCode() == KeyEvent.VK_SLASH ||e.getKeyCode() == KeyEvent.VK_EQUALS ||
                        e.getKeyCode() == KeyEvent.VK_MODECHANGE)
                    Result(e.getKeyChar());
            }
        });
        calcFrame.setFocusable(true);
    }

    /**
     * find the result by num1 and sign and num2
     * @param t
     */
    public void Result(char t){
        if (t =='0' || t =='1' || t =='2' || t =='3' ||
                t =='4' || t =='5' || t =='6'||
                t =='7' || t =='8' ||t =='9'){
            if (!sign.equals(""))
                num2 += t;
            else
                num1 += t;

            display.setText(num1 +sign +num2);
        }

        else if (t == '=') {
            double answer=0;
            if (sign.equals("+"))
                answer = Double.parseDouble(num1) + Double.parseDouble(num2);
            else if (sign.equals("-"))
                answer = Double.parseDouble(num1) - Double.parseDouble(num2);
            else if (sign.equals("%"))
                answer = Double.parseDouble(num1) % Double.parseDouble(num2);
            else if (sign.equals("÷")|| sign.equals("/"))
                answer = Double.parseDouble(num1) / Double.parseDouble(num2);
            else
                answer = Double.parseDouble(num1) * Double.parseDouble(num2);

            display.setText(num1 +sign +num2 +"=" +String.valueOf(answer));
            num1 = String.valueOf(answer);
            num2 = sign = "";
        }

        else {
            double answer=0;
            if (num1.equals("") || num2.equals(""))
                sign = String.valueOf(t);
            else {

                if (sign.equals("+"))
                    answer = Double.parseDouble(num1) + Double.parseDouble(num2);
                else if (sign.equals("-"))
                    answer = Double.parseDouble(num1) - Double.parseDouble(num2);
                else if (sign.equals("%"))
                    answer = Double.parseDouble(num1) % Double.parseDouble(num2);
                else if (sign.equals("÷")|| sign.equals("/"))
                    answer = Double.parseDouble(num1) / Double.parseDouble(num2);
                else if (sign.equals("*"))
                    answer = Double.parseDouble(num1) * Double.parseDouble(num2);

                num1 = String.valueOf(answer);
                num2 = "";
                sign = String.valueOf(t);
            }
            display.setText(num1 +sign +num2);
        }

    }



    public class GUI implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton t = (JButton) e.getSource();
            char test = t.getText().charAt(0);
            Result(test);
        }
    }





}