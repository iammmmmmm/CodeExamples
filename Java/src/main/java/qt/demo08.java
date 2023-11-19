package qt;

import io.qt.gui.QIcon;
import io.qt.gui.QPixmap;
import io.qt.widgets.QApplication;
import io.qt.widgets.QSystemTrayIcon;
import io.qt.widgets.QWidget;
import org.slf4j.Logger;

/**
 * 实现系统托盘
 *
 * @author Iammm
 * @date 2023/11/16 16:40
 */
public class demo08 {

    public static void main(String[] args) {
        System.setProperty("java.library.path", "C:\\Qt\\6.6.0\\msvc2019_64\\bin");
        new myTray(args);
    }
}

class myTray {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(myTray.class);

    public myTray(String[] args) {

        QApplication.initialize(args);
        QWidget widget = new QWidget();
        widget.show();
        QSystemTrayIcon m_systemTray = new QSystemTrayIcon(widget);
        // 设置托盘的图标
        //！！！
        // 必须设置图标，否则不显示  :(
        m_systemTray.setIcon(new QIcon(new QPixmap("src/main/resources/wallhaven-6dykgx.png")));
        // 如果此时再用错误的路径设置一次，托盘就会变成透明图标
        m_systemTray.setIcon(new QIcon(new QPixmap(":fd52ac76a3dd75bebfa9370bf6a2769520e6b336.jpg")));
        // 设置托盘的提示信息，当鼠标移动到托盘的时候显示
        m_systemTray.setToolTip("SystemTray Program");
        // 显示托盘
        m_systemTray.show();
        m_systemTray.showMessage("sss", "sss");

        m_systemTray.messageClicked.connect(() -> m_systemTray.showMessage("sss", "sss2"));

        m_systemTray.activated.connect(e -> logger.debug("t3 e:{}", e));
        logger.debug("t1");
        QApplication.exec();
        logger.debug("t");
    }

}
