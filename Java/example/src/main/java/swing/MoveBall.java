package swing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 移动球 ，一个可以用wasd移动的球的示例
 *
 * @author Iammm
 * @date 2023/10/21 18:55
 */
public class MoveBall {
    /**
     * 日志
     */
    private final Logger LOGGER = LoggerFactory.getLogger(MoveBall.class);

    /**
     * 主要
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        new MoveBall().run();
    }

    /**
     * 跑
     */
    private void run() {
        JFrame frame = new JFrame("Move Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);//窗口在屏幕中间显示
        drawBall(frame);
        frame.setVisible(true);
    }

    /**
     * 抽球
     *
     * @param frame 框架
     */
    private void drawBall(JFrame frame) {
        ball myball = new ball();
        frame.addKeyListener(myball);
        frame.addMouseListener(myball);
        frame.add(myball);
    }


}

class ball extends JPanel implements KeyListener, MouseListener {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    int x = 100;
    int y = 100;
    int width = 100;
    int height = 100;

    public ball() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        LOGGER.debug("g size:{}",g.getClipBounds());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillOval(x, y, width, height);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, width, height);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                y -= 1;
                repaint();
            }
            case KeyEvent.VK_S -> {
                y += 1;
                repaint();
            }
            case KeyEvent.VK_A -> {
                x -= 1;
                repaint();
            }
            case KeyEvent.VK_D -> {
                x += 1;
                repaint();
            }
            default -> LOGGER.info("Unexpected value: " + e.getKeyCode());
            // default -> throw new IllegalStateException("Unexpected value: " + e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
