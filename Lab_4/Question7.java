import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question7 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}

class Calculator extends JFrame implements ActionListener {
    JTextField display;
    JButton[] buttons;

    String[] buttonNames = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "C", "+",
        "="
    };

    double num1, num2, result;
    char operator;

    Calculator() {
        setTitle("Calculator");
        setSize(350, 450);
        setLayout(new BorderLayout(10, 10));

        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        buttons = new JButton[buttonNames.length];

        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();

        if (value.equals("C")) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
        else if (value.equals("+") || value.equals("-")
                || value.equals("*") || value.equals("/")) {

            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = value.charAt(0);
                display.setText("");
            }
        }
        else if (value.equals("=")) {
            if (!display.getText().isEmpty()) {
                num2 = Double.parseDouble(display.getText());

                if (operator == '+') {
                    result = num1 + num2;
                }
                else if (operator == '-') {
                    result = num1 - num2;
                }
                else if (operator == '*') {
                    result = num1 * num2;
                }
                else if (operator == '/') {
                    if (num2 == 0) {
                        display.setText("Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                }

                display.setText(String.valueOf(result));
            }
        }
        else {
            display.setText(display.getText() + value);
        }
    }
}
