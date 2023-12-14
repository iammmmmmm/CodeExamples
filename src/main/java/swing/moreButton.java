package swing;

import javax.swing.*;
import java.awt.*;

/**
 * 更多！请主人注入更多~~~啊~~~按钮
 * ( 生成许多的按钮 )
 *
 * @author Iammm
 * @Time 2023/12/14 15:56
 */
public class moreButton {
    public static void main(String[] args) {
        var jf = new JFrame("moreButton");
        jf.setLayout(new FlowLayout());
        moreMoreMore(jf, 15);
        jf.pack();
        jf.setVisible(true);
    }

    private static void moreMoreMore(JFrame jf, int num) {
        for (int i = 0; i < num; i++) {
            var b = new JButton("moreMoreMore" + i);
            int finalI = i;
            b.addActionListener(e -> {
                say(finalI);
            });
            jf.add(b);
        }
    }

    private static void say(int s) {
        System.out.println("moreMoreMore" + s);
    }
}
