package swing;

/**
 * AI写的不规则多边形例子
 *
 * @author AI
 * @date 2023/10/23 13:40
 * @description
 */

import javax.swing.*;
import java.awt.*;

public class IrregularPolygonExample extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 创建一个不规则五边形的坐标数组
        int[] xPoints = {50, 100, 200, 150, 75};
        int[] yPoints = {150, 50, 100, 200, 225};

        // 创建不规则多边形对象
        Polygon polygon = new Polygon(xPoints, yPoints, xPoints.length);

        // 设置绘制颜色
        g.setColor(Color.BLUE);

        // 绘制不规则多边形
        g.drawPolygon(polygon);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        IrregularPolygonExample panel = new IrregularPolygonExample();
        frame.add(panel);

        frame.setVisible(true);
    }
}

