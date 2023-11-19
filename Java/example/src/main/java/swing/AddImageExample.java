package swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**swing添加图片示例
*@author Iammm
*@date 2023/10/21 18:53
 *
*/
public class AddImageExample {
    public static void main(String[] args) {
        // 创建一个JFrame窗口
        JFrame frame = new JFrame("添加图片示例");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个JLabel组件
        JLabel label = new JLabel();

        // 创建一个ImageIcon对象，并将其设置为JLabel的图标
        ImageIcon icon = new ImageIcon("D:\\code\\java_Study_ZK\\src\\main\\java\\swing\\xPhone\\icon.png");
        label.setIcon(icon);

        // 将JLabel添加到JFrame中
        frame.getContentPane().add(label);

        // 设置窗口大小
        frame.setSize(300, 300);

        // 显示窗口
        frame.setVisible(true);
    }
}
