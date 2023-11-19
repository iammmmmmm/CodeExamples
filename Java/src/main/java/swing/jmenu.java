package swing;

import javax.swing.*;

/**
 * jmenu
 *
 * @author admin
 * @date 2023/11/19
 */
public class jmenu {
    /**
     * 主要
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        new jmenu().go();
    }

    /**
     * 去
     */
    private void go() {
        JFrame frame = new JFrame("jmenu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("New");
        menu.add(menuItem);

        menu.add(new JMenuItem("Open"));
        menu.addSeparator();
        menu.add(new JMenuItem("Exit"));
        menu.add(new JMenuItem("Save"));

        menu.addSeparator();


        JMenu menu1 = new JMenu("---");
        menuBar.add(menu1);
        menu1.add(new JMenuItem("New"));
        menu1.add(new JMenuItem("Open"));
        menu1.addSeparator();
        menu1.add(new JMenuItem("Exit"));

        // Add the menubar to the frame
        frame.setJMenuBar(menuBar);
        frame.setLocation(500, 500);
        frame.setVisible(true);
    }
}
