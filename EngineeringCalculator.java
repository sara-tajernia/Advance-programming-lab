import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EngineeringCalculator {

    private JFrame calcFrame;
    private JPanel keyboardPanel;
    private JTextArea display;
    private String sign = "";
    private String num1 = "";
    private String num2 = "";
    private String saving = "0";
    private boolean change = false;

    public EngineeringCalculator() {
        calcFrame = new JFrame();
        calcFrame.setTitle("AUT Calculator");
        calcFrame.setSize(350, 550);
        calcFrame.setLocation(100, 100);
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

    public void KeyBoard(){
        keyboardPanel = new JPanel();
        keyboardPanel.setSize(200,250);
        keyboardPanel.setLocation(75, 200);
        keyboardPanel.setLayout(new GridLayout(6,4));
        GUI handler = new GUI();

        for (int i=7;i<10;i++){
            JButton btn = new JButton("" + i);
            btn.addActionListener(handler);
            keyboardPanel.add(btn);
        }

        JButton divisionBtn = new JButton("÷");
        divisionBtn.addActionListener(handler);
        divisionBtn.setToolTipText("Division");
        keyboardPanel.add(divisionBtn);

        for (int i=4;i<7;i++){
            JButton btn = new JButton("" + i);
            btn.addActionListener(handler);
            keyboardPanel.add(btn);
        }

        JButton multiBtn = new JButton("×");
        multiBtn.addActionListener(handler);
        multiBtn.setToolTipText("Multiply");
        keyboardPanel.add(multiBtn);

        for (int i=1;i<4;i++){
            JButton btn = new JButton("" + i);
            btn.addActionListener(handler);
            keyboardPanel.add(btn);
        }
        JButton minesBtn = new JButton("-");
        minesBtn.addActionListener(handler);
        minesBtn.setToolTipText("Subtraction");
        keyboardPanel.add(minesBtn);

        JButton doBtn = new JButton("=");
        doBtn.addActionListener(handler);
        doBtn.setToolTipText("Equal");
        keyboardPanel.add(doBtn);

        JButton zeroBtn = new JButton("0");
        zeroBtn.addActionListener(handler);
        keyboardPanel.add(zeroBtn);

        JButton modBtn = new JButton("%");
        modBtn.addActionListener(handler);
        modBtn.setToolTipText("Mod");
        keyboardPanel.add(modBtn);

        JButton sumBtn = new JButton("+");
        sumBtn.addActionListener(handler);
        sumBtn.setToolTipText("Mod");
        keyboardPanel.add(sumBtn);

        JButton shift = new JButton("Shf");
        shift.addActionListener(handler);
        shift.setToolTipText("Change some buttons");
        keyboardPanel.add(shift);


        JButton C = new JButton("C");
        C.addActionListener(handler);
        C.setToolTipText("clear the screen");
        keyboardPanel.add(C);

        JButton dot = new JButton(".");
        dot.addActionListener(handler);
        keyboardPanel.add(dot);

        JButton piBtn = new JButton("π");
        piBtn.addActionListener(handler);
        piBtn.setToolTipText("pi = 3.14");
        keyboardPanel.add(piBtn);

        JButton sinBtn = new JButton("sin");
        sinBtn.addActionListener(handler);
//        keyboardPanel.add(sinBtn);

        JButton cosBtn = new JButton("cos");
        cosBtn.addActionListener(handler);
//        keyboardPanel.add(cosBtn);

        JButton logBtn = new JButton("log");
        logBtn.addActionListener(handler);
//        keyboardPanel.add(logBtn);

        JButton tanBtn = new JButton("tan");
        tanBtn.addActionListener(handler);
//        keyboardPanel.add(tanBtn);

        JButton cotBtn = new JButton("cot");
        cotBtn.addActionListener(handler);
//        keyboardPanel.add(cotBtn);

        JButton eBtn = new JButton("e");
        eBtn.addActionListener(handler);
//        keyboardPanel.add(eBtn);

        if (change){
            System.out.println("it have");
            keyboardPanel.remove(sinBtn);
            keyboardPanel.remove(cosBtn);
            keyboardPanel.remove(logBtn);

            keyboardPanel.add(tanBtn);
            keyboardPanel.add(cotBtn);
            keyboardPanel.add(eBtn);
        }
        else {
            System.out.println("it have not");
            keyboardPanel.remove(tanBtn);
            keyboardPanel.remove(cotBtn);
            keyboardPanel.remove(eBtn);

            keyboardPanel.add(sinBtn);
            keyboardPanel.add(cosBtn);
            keyboardPanel.add(logBtn);
        }

        calcFrame.add(keyboardPanel);

    }


    /**
     * create a JTextArea for show the numbers and sign
     */
    public void Screen(){
        display = new JTextArea();
        display.setEditable(false);
        display.setFont(new Font("Arial", 25,25));
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setSize(200, 100);
        scrollPane.setLocation(75,40);
        calcFrame.getContentPane().add(scrollPane);

    }

    /**
     * to respond we type the numbers and sign(only *(multiply) /(division) +(plus)
     *   -(minus) %(mod) =(equals) s(sin) c(cos) l(log) p(pi) shift(shift)
     *     C(erase) k(cot) e(exp) .(dot) t(tan)and show them on JTextArea
     */

    public void KeyHandeling(){
        calcFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_PLUS)
                    System.exit(0);
                if (e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_1 ||e.getKeyCode() == KeyEvent.VK_2 ||
                        e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5 ||
                        e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_8 ||
                        e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode() == KeyEvent.VK_MINUS ||
                        e.getKeyCode() == KeyEvent.VK_MULTIPLY || e.getKeyCode() == KeyEvent.VK_SLASH ||e.getKeyCode() == KeyEvent.VK_EQUALS ||
                        e.getKeyCode() == KeyEvent.VK_MODECHANGE || e.getKeyCode() == KeyEvent.VK_S ||e.getKeyCode() == KeyEvent.VK_C ||
                        e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_L || e.getKeyCode() == KeyEvent.VK_P ||
                        e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_PERIOD)
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
        System.out.println(t);
        GUI handler = new GUI();
        if (t =='0' || t =='1' || t =='2' || t =='3' ||
                t =='4' || t =='5' || t =='6'||
                t =='7' || t =='8' ||t =='9'|| t=='.'){
            if (!sign.equals(""))
                num2 += t;
            else
                num1 += t;

            display.setText(num1 +sign +num2);
        }
        else if (t =='C'){
            num1 = num2 = sign = "";
            display.setText("");
        }
        else if (t == 'π' || t =='p'){
            if (num1 == "")
                num1 = String.valueOf(Math.PI);
            else {
                num2 = String.valueOf(Math.PI);
            }

            display.setText(num1 +sign +num2);
        }
        else if (t =='S'){
            System.out.println("gjy");
            if (change)
                change = false;
            else
                change = true;
//            EngineeringCalculator();
            KeyBoard();
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
            else if (sign.equals("×"))
                answer = Double.parseDouble(num1) * Double.parseDouble(num2);
            else if (sign.equals("s")) {
                sign = "sin";
                answer = Math.sin(Double.parseDouble(num1));
            }
            else if (sign.equals("c")) {
                sign = "cos";
                answer = Math.cos(Double.parseDouble(num1));
            }
            else if (sign.equals("l")) {
                sign = "log";
                answer = Math.log(Double.parseDouble(num1));
            }
            else if (sign.equals("e")){
                answer = Math.exp(Double.parseDouble(num1));
            }
            else if (sign.equals("t")) {
                sign = "tan";
                answer = Math.tan(Double.parseDouble(num1));
            }
            else if (sign.equals("k")) {
                sign = "cot";
                answer = 1/Math.tan(Double.parseDouble(num1));
            }
//            else if (sign.equals("S")){
//                if (change)
//                    change = false;
//                else
//                    change = true;
//            }

            display.setText(num1 +sign +num2 +"=" +String.valueOf(answer));
            num1 = String.valueOf(answer);
            num2 = sign = "";
        }

        else {
            double answer=0;
            if (num1.equals("") || num2.equals("")) {
                   sign = String.valueOf(t);
            }
            else {
                if (sign.equals("+"))
                    answer = Double.parseDouble(num1) + Double.parseDouble(num2);
                else if (sign.equals("-"))
                    answer = Double.parseDouble(num1) - Double.parseDouble(num2);
                else if (sign.equals("%"))
                    answer = Double.parseDouble(num1) % Double.parseDouble(num2);
                else if (sign.equals("÷")|| sign.equals("/"))
                    answer = Double.parseDouble(num1) / Double.parseDouble(num2);
                else if (sign.equals("×"))
                    answer = Double.parseDouble(num1) * Double.parseDouble(num2);
                else if (sign.equals("s")) {
                    sign = "sin";
                    answer = Math.sin(Double.parseDouble(num1));
                }
                else if (sign.equals("c")) {
                    sign = "cos";
                    answer = Math.cos(Double.parseDouble(num1));
                }
                else if (sign.equals("l")) {
                    sign = "log";
                    answer = Math.log(Double.parseDouble(num1));
                }
                else if (sign.equals("e")){
                    answer = Math.exp(Double.parseDouble(num1));
                }
                else if (sign.equals("k")) {
                    sign = "cot";
                    answer = 1/Math.tan(Double.parseDouble(num1));
                }
//                else if (sign.equals("S")){
//                    if (change)
//                        change = false;
//                    else
//                        change = true;
//                }

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
