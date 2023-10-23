package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SetTextAlignmentExample {
    public static void main(String[] args) {
        // 创建一个JFrame窗口
        JFrame frame = new JFrame("设置文字居中示例");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个JLabel组件
        JLabel label = new JLabel("居中对齐的文字");

        // 设置水平居中对齐
        label.setHorizontalAlignment(JLabel.CENTER);

        // 将JLabel添加到JFrame中
        frame.getContentPane().add(label);

        // 设置窗口大小
        frame.setSize(300, 300);

        // 显示窗口
        frame.setVisible(true);
    }
}