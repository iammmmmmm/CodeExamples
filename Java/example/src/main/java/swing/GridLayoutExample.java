package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 2)); // 设置GridLayout，行数为1，列数为0

        for (int i = 0; i < 4; i++) {
            JButton button = new JButton("Button " + (i + 1));
            frame.add(button); // 添加按钮到布局
        }
        for (int i = 0; i < 4; i++) {
            JButton button = new JButton("Button " + (i + 1));
            frame.add(button); // 添加按钮到布局
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
