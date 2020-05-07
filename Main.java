import javax.swing.*;

public class Main {

    JFrame f;
    Main(){

//        CalculatorGUI calculator = new CalculatorGUI();
        f=new JFrame();
        JTextArea ta=new JTextArea(200,200);
//        JFrame j1 = new JFrame();
//        j1.add(calculator);
        JPanel p1=new JPanel();
        p1.add(ta);
        JPanel p2=new JPanel();
//        p2.add(ta);
        JTabbedPane tp=new JTabbedPane();
        tp.setBounds(50,50,350,500);
        tp.add("Basic Calculator",p1);
        tp.add("Engineering Calculator",p2);
        f.add(tp);
        f.setSize(450,600);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {

//        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) { UIManager.setLookAndFeel(info.getClassName()); break;
//                } }
//        } catch (Exception e) {
//// If Nimbus is not available, you can set the GUI to another look and feel.
//        }

//        new Main();
        CalculatorGUI calculator = new CalculatorGUI();
        EngineeringCalculator EC = new EngineeringCalculator();
    }
}