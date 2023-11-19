package swing.碰撞检测.点;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Iammm
 * @date 2023/10/21 19:05
 * @description 如名 , 实现平滑移动是用一个集合解决的，按下任意键--》获取按键-->添加进集合-->对集合内的键进行响应 | 松开键--》获取键--》从集合中删除
 */
public class point {
    private JPanel panel;

    public static void main(String[] args) {
        new point().run();
    }

    private void run() {
        JFrame frame = new JFrame("碰撞检测--点");
        frame.setSize(400, 400);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pointPanel point1 = new pointPanel(1, 2, 3);
        frame.add(point1);
        frame.addKeyListener(point1);
        frame.setVisible(true);
    }

    private static class pointPanel extends JPanel implements KeyListener {
        private final Logger LOGGER = LoggerFactory.getLogger(pointPanel.class);
        private final HashSet<Integer> pressed = new HashSet<>();
        private int x = 10;
        private int y = 10;
        private int radius = 10;


        double threshold = 0;

        public pointPanel(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(radius));
            // no point so ⬇️🤪
            g2d.drawLine(x, y, x, y);
        }


        /**
         * @param e the event to be processed
         */
        @Override
        public void keyTyped(KeyEvent e) {

        }

        /**
         * @param e the event to be processed
         */
        @Override
        public void keyPressed(KeyEvent e) {
            pressed.add(e.getKeyCode());
            keyReplace(pressed);
        }

        private void keyReplace(Set pressed) {
            for (Object i : pressed) {
                switch ((int) i) {
                    case KeyEvent.VK_W -> y--;
                    case KeyEvent.VK_S -> y++;
                    case KeyEvent.VK_A -> x--;
                    case KeyEvent.VK_D -> x++;
                    case KeyEvent.VK_ADD -> radius++;
                    case KeyEvent.VK_SUBTRACT -> radius--;
                    default -> LOGGER.debug("ex key {}", i);
                }
                if (radius <= 0) {
                    radius = 1;
                }
                repaint();
            }
        }

        /**
         * @param e the event to be processed
         */
        @Override
        public void keyReleased(KeyEvent e) {
            pressed.remove(e.getKeyCode());
        }
    }

    private static class ImpactChecking {
        boolean isImpact(point a, point b) {
            boolean isImpact = false;


            return isImpact;
        }
    }
}

