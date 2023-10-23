package swing;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListenerTest extends JFrame implements KeyListener {

    public KeyboardListenerTest() {
        setTitle("Keyboard Listener Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JTextField textField = new JTextField();
        textField.addKeyListener(this);

        add(textField);

        setVisible(true);
    }

    public static void main(String[] args) {
        new KeyboardListenerTest();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 监听键盘的按键输入事件
        // 只有在按下键时才会触发
        // 可以在这里处理相应的逻辑
        // 例如，判断输入的字符是否合法
        char c = e.getKeyChar();
        System.out.println("Key Typed: " + c);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 监听键盘的按键按下事件
        // 按下键后会触发一次
        // 可以在这里处理相应的逻辑
        int keyCode = e.getKeyCode();
        System.out.println("Key Pressed: " + keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 监听键盘的按键释放事件
        // 松开键后会触发一次
        // 可以在这里处理相应的逻辑
        int keyCode = e.getKeyCode();
        System.out.println("Key Released: " + keyCode);
    }
}
