//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    //Fields
    private JFrame frame;
    private JTextArea textArea = new JTextArea();
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private final Font numbersFont = new Font("arial", Font.ITALIC, 16);
    private final Font textFieldFont = new Font("tahoma", Font.PLAIN, 40);

    //Operator
    private int num1;
    private int num2;
    private int total;
    private String strNum1;
    private String strNum2;
    private String[] statement;


    //Number Buttons:
    JButton btn0 = new JButton("0");
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");


    //Operator Buttons:
    JButton btnAdd = new JButton("+");
    JButton btnMinus = new JButton("-");
    JButton btnMul = new JButton("X");
    JButton btnDiv = new JButton("/");
    JButton btnSqrt = new JButton("√");
    JButton btnBackspace = new JButton("←");
    JButton btnClear = new JButton("C");
    JButton btnEqual = new JButton("=");


    //Constructor
    public Calculator() {
        design();
        append();
        actionListener();
    }

    public void design() {

        try {
            // This line set Windows Theme
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Text Field / Display:

        textArea.setBounds(10, 10, 375, 90);
        textArea.setEditable(false);
        textArea.setFont(textFieldFont);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.decode("#232323"));

        //Buttons:
        final int BTN_WIDTH = 75;
        final int BTN_HEIGHT = 40;
        //Numbers {
        //btn0:
        btn0.setBounds(10, 305, 236, 50);
        btn0.setForeground(Color.WHITE);
        btn0.setBackground(Color.decode("#070707"));
        btn0.setFont(numbersFont);

        //btn1:
        btn1.setBounds(10, 260, BTN_WIDTH, BTN_HEIGHT);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#070707"));
        btn1.setFont(numbersFont);

        //btn2:
        btn2.setBounds(90, 260, BTN_WIDTH, BTN_HEIGHT);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#070707"));
        btn2.setFont(numbersFont);

        //btn3:
        btn3.setBounds(170, 260, BTN_WIDTH, BTN_HEIGHT);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#070707"));
        btn3.setFont(numbersFont);

        //btn4:
        btn4.setBounds(10, 214, BTN_WIDTH, BTN_HEIGHT);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#070707"));
        btn4.setFont(numbersFont);

        //btn5:
        btn5.setBounds(90, 214, BTN_WIDTH, BTN_HEIGHT);
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(Color.decode("#070707"));
        btn5.setFont(numbersFont);

        //btn6:
        btn6.setBounds(170, 214, BTN_WIDTH, BTN_HEIGHT);
        btn6.setForeground(Color.WHITE);
        btn6.setBackground(Color.decode("#070707"));
        btn6.setFont(numbersFont);

        //btn7:
        btn7.setBounds(10, 168, BTN_WIDTH, BTN_HEIGHT);
        btn7.setForeground(Color.WHITE);
        btn7.setBackground(Color.decode("#070707"));
        btn7.setFont(numbersFont);

        //btn8:
        btn8.setBounds(90, 168, BTN_WIDTH, BTN_HEIGHT);
        btn8.setForeground(Color.WHITE);
        btn8.setBackground(Color.decode("#070707"));
        btn8.setFont(numbersFont);

        //btn9:
        btn9.setBounds(170, 168, BTN_WIDTH, BTN_HEIGHT);
        btn9.setForeground(Color.WHITE);
        btn9.setBackground(Color.decode("#070707"));
        btn9.setFont(numbersFont);

        //Operators {

        //btnEqual:
        btnEqual.setBounds(250, 305, 133, 50);
        btnEqual.setBackground(Color.decode("#16354E"));
        btnEqual.setForeground(Color.WHITE);
        btnEqual.setFont(numbersFont);

        //btnAdd:
        btnAdd.setBounds(250, 260, 133, BTN_HEIGHT);
        btnAdd.setBackground(Color.decode("#2A2A2A"));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(numbersFont);

        //btnMinus:
        btnMinus.setBounds(250, 214, 133, BTN_HEIGHT);
        btnMinus.setBackground(Color.decode("#2A2A2A"));
        btnMinus.setForeground(Color.WHITE);
        btnMinus.setFont(numbersFont);

        //btnMul:
        btnMul.setBounds(250, 168, 133, BTN_HEIGHT);
        btnMul.setBackground(Color.decode("#2A2A2A"));
        btnMul.setForeground(Color.WHITE);
        btnMul.setFont(numbersFont);

        //btnDiv:
        btnDiv.setBounds(250, 123, 133, BTN_HEIGHT);
        btnDiv.setBackground(Color.decode("#2A2A2A"));
        btnDiv.setForeground(Color.WHITE);
        btnDiv.setFont(numbersFont);

        //btnSqrt:
        btnSqrt.setBounds(170, 123, BTN_WIDTH, BTN_HEIGHT);
        btnSqrt.setBackground(Color.decode("#2A2A2A"));
        btnSqrt.setForeground(Color.WHITE);
        btnSqrt.setFont(numbersFont);

        //btnBackspace:
        btnBackspace.setBounds(90, 123, BTN_WIDTH, BTN_HEIGHT);
        btnBackspace.setBackground(Color.decode("#2A2A2A"));
        btnBackspace.setForeground(Color.WHITE);
        btnBackspace.setFont(numbersFont);

        //btnClear:
        btnClear.setBounds(10, 123, BTN_WIDTH, BTN_HEIGHT);
        btnClear.setBackground(Color.decode("#2A2A2A"));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(numbersFont);


        //Frame set
        frame = new JFrame("Calculator");
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setBackground(Color.decode("#232323"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);


        //Adding
        frame.add(textArea);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);
        frame.add(btn7);
        frame.add(btn8);
        frame.add(btn9);
        frame.add(btnAdd);
        frame.add(btnMinus);
        frame.add(btnMul);
        frame.add(btnDiv);
        frame.add(btnEqual);
        frame.add(btnSqrt);
        frame.add(btnBackspace);
        frame.add(btnClear);

        int max = 9;
        if (textArea.getText().length() - 1 > max) {
            return;
        }


        frame.setLayout(null);
        frame.setVisible(true);


    }

    public void append() {

        btn0.addActionListener(e -> textArea.append("0"));

        btn1.addActionListener(e -> textArea.append("1"));

        btn2.addActionListener(e -> textArea.append("2"));

        btn3.addActionListener(e -> textArea.append("3"));

        btn4.addActionListener(e -> textArea.append("4"));

        btn5.addActionListener(e -> textArea.append("5"));

        btn6.addActionListener(e -> textArea.append("6"));

        btn7.addActionListener(e -> textArea.append("7"));

        btn8.addActionListener(e -> textArea.append("8"));

        btn9.addActionListener(e -> textArea.append("9"));

        btnAdd.addActionListener(e -> textArea.append("+"));

        btnMinus.addActionListener(e -> textArea.append("-"));

        btnMul.addActionListener(e -> textArea.append("*"));

        btnDiv.addActionListener(e -> textArea.append("/"));

        btnSqrt.addActionListener(e -> textArea.append("√()"));

    }

    public void actionListener() {

        btnEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textArea.getText().contains("+")) {
                    statement = textArea.getText().split("\\+");
                    strNum1 = statement[0];
                    strNum2 = statement[1];

                    num1 = Integer.parseInt(strNum1);
                    num2 = Integer.parseInt(strNum2);

                    total = num1 + num2;
                    textArea.setText(Integer.toString(total));
                } else if (textArea.getText().contains("-")) {
                    statement = textArea.getText().split("\\-");
                    strNum1 = statement[0];
                    strNum2 = statement[1];

                    num1 = Integer.parseInt(strNum1);
                    num2 = Integer.parseInt(strNum2);

                    total = num1 - num2;
                    textArea.setText(Integer.toString(total));
                } else if (textArea.getText().contains("*")) {
                    statement = textArea.getText().split("\\*");
                    strNum1 = statement[0];
                    strNum2 = statement[1];

                    num1 = Integer.parseInt(strNum1);
                    num2 = Integer.parseInt(strNum2);

                    total = num1 * num2;
                    textArea.setText(Integer.toString(total));
                } else if (textArea.getText().contains("/")) {
                    statement = textArea.getText().split("\\/");
                    strNum1 = statement[0];
                    strNum2 = statement[1];

                    num1 = Integer.parseInt(strNum1);
                    num2 = Integer.parseInt(strNum2);

                    total = num1 / num2;
                    textArea.setText(Integer.toString(total));
                } else if (textArea.getText().contains("√()")) {
                    statement = textArea.getText().split("\\√");
                    strNum1 = statement[0];

                    double sqrt = Double.parseDouble(strNum1);
                    double dTotal;
                    dTotal = Math.sqrt(sqrt);
                    String res = String.format("%.7f", dTotal);
                    textArea.setText(res);
                }
            }
        });

        btnBackspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText().substring(0, textArea.getText().length() - 1));
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "";
                if (textArea.getText() != null) {
                    textArea.setText(str);
                }
            }
        });

    }


}//End Of Class
