package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private Display display;
    private KeyPad keyPad;
    private Operations logic;

    Calculator() {
        display = new Display();
        keyPad = new KeyPad(new ButtonClickListener());
        logic = new Operations();

        add(display.getPanel(), BorderLayout.NORTH);
        add(keyPad.getPanel(), BorderLayout.CENTER);
        getContentPane().setBackground(Color.decode("#1E1E1E"));

        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            processCommand(cmd);
        }
    }

    public void processCommand(String cmd) {
        switch (cmd) {
            case "C" -> {
                logic.clear();
                display.clear();
            }
            case "+", "-", "/", "*" -> {
                logic.setCurrentOperation(cmd);
                logic.setNewNumber(true);
            }
            case "=" -> {
                try {
                    double result = logic.result();
                    display.setTextField(String.valueOf(result));
                } catch (ArithmeticException e) {
                    display.setTextField("Error");
                    logic.clear();
                }
            }
            default -> {
                if (logic.isNewNumber()) {
                    display.setTextField(cmd);
                    logic.setNewNumber(false);
                } else {
                    display.appendToDisplay(cmd);
                }
                logic.setCurrentNumber(Double.parseDouble(display.getTextField()));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calc = new Calculator();
            calc.setVisible(true);
        });
    }
}
