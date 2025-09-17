package Calculator;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JPanel panel;
    private JTextField textField;

    Display() {
        panel = new JPanel();
        textField = new JTextField("0");
        textField.setFont(new Font("Arial", Font.BOLD, 36));
        textField.setBackground(Color.decode("#383838"));
        textField.setForeground(Color.CYAN);
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(480, 80));
        textField.setFocusable(false);
        textField.setBorder(null);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);


        panel.add(textField);
        panel.setOpaque(false);
        panel.setVisible(true);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public String getTextField() {
        return textField.getText();
    }

    public void setTextField(String number) {
        textField.setText(number);
    }

    public void appendToDisplay(String text) {
        textField.setText(textField.getText() + text);
    }

    public void clear() {
        textField.setText("0");
    }
}
