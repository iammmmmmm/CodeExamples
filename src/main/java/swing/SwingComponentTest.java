package swing;

// import swing.NbPheon23ProMaxPPP.BackgroundPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 摆动部件测试
 *
 * @author iam
 * @date 2023/11/19
 */
public class SwingComponentTest {
    /**
     * 主要
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame("Swing Component Test");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

//        BackgroundPanel background = new BackgroundPanel();
//        frame.add(background);

        // 创建文本框
        JTextField textField = new JTextField(20);
        frame.add(textField);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        // 创建按钮
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> {
            String text = textField.getText();
            JOptionPane.showMessageDialog(frame, "You entered: " + text);
        });
        panel.add(button);
        // 创建按钮
        JButton button1 = new JButton("Click Me22222");
        button1.addActionListener(e -> {
            String text = textField.getText();
            JOptionPane.showMessageDialog(frame, "You entered: " + text);
        });
        panel.add(button1);
        frame.add(panel);
        // 创建复选框
        JCheckBox checkBox = new JCheckBox("Check Box");
        frame.add(checkBox);

        // 创建单选按钮
        JRadioButton radioButton1 = new JRadioButton("Radio Button 1");
        JRadioButton radioButton2 = new JRadioButton("Radio Button 2");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        frame.add(radioButton1);
        frame.add(radioButton2);

        // 创建下拉列表框
        String[] options = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        frame.add(comboBox);

        // 创建列表框
        String[] listData = {"Item 1", "Item 2", "Item 3"};
        JList<String> list = new JList<>(listData);
        frame.add(new JScrollPane(list));

        // 创建滚动条
        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 100);
        frame.add(scrollBar);

        // 创建标签
        JLabel label = new JLabel("Label");
        frame.add(label);

        // 显示窗口
        frame.setVisible(true);
    }
}