package swing;

import javax.swing.*;
import java.awt.*;

public class SwingFlowLayout {
    public static void main(String[] args) {
        new SwingFlowLayout().go();
        String[] args2 = new String[0];
        int[] args3 = new int[0];
    }

    void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JButton("Button 1"), FlowLayout.LEFT);
        panel.add(new JButton("Button 2"), FlowLayout.CENTER);
        panel.add(new JButton("Button 3"), FlowLayout.RIGHT);
        panel.add(new JButton("Button 4"), FlowLayout.LEADING);
        panel.add(new JButton("Button 5"), FlowLayout.TRAILING);

        frame.add(panel);

        // Display the window.
        frame.setVisible(true);

    }
}
