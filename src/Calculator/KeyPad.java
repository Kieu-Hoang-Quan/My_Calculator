package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class KeyPad {
    private JPanel panel;
    private final String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
    };

    public KeyPad(ActionListener listener) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setOpaque(false);
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setBackground(Color.decode("#272727"));
            button.setBorder(BorderFactory.createLineBorder(Color.CYAN, 1));
            button.setFocusable(false);
            button.setForeground(Color.CYAN);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(listener);
            panel.add(button);
        }
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
