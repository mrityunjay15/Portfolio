/* code created By Mrityunjay Prajapati 
   27/12/2024
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private String operator;
    private double operand1, operand2, result;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 30));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        add(textField, BorderLayout.NORTH);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "CE", "Back", "%"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            buttonPanel.add(button);
            button.setBackground(Color.YELLOW);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case "C": 
                    textField.setText("");
                    operator = null;
                    operand1 = operand2 = result = 0;
                    break;

                case "CE": 
                    textField.setText("");
                    break;

                case "Back":
                    String text = textField.getText();
                    if (!text.isEmpty()) {
                        textField.setText(text.substring(0, text.length() - 1));
                    }
                    break;

                case "+": case "-": case "*": case "/": case "%":
                    operator = command;
                    operand1 = Double.parseDouble(textField.getText());
                    textField.setText("");
                    break;

                case "=":
                    if (operator != null && !textField.getText().isEmpty()) {
                        operand2 = Double.parseDouble(textField.getText());
                        switch (operator) {
                            case "+":
                                result = operand1 + operand2;
                                break;
                            case "-":
                                result = operand1 - operand2;
                                break;
                            case "*":
                                result = operand1 * operand2;
                                break;
                            case "/":
                                if (operand2 != 0) {
                                    result = operand1 / operand2;
                                } else {
                                    textField.setText("Error: Division by 0");
                                    operator = null;
                                    return;
                                }
                                break;
                            case "%":
                                result = operand1 % operand2;
                                break;
                        }
                        textField.setText(String.valueOf(result));
                        operator = null; 
                    }
                    break;

                default: 
                    textField.setText(textField.getText() + command);
                    break;
            }
        } catch (NumberFormatException ex) {
            textField.setText("Error: Invalid Input");
        }
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}
