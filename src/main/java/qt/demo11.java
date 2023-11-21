package qt;

import io.qt.gui.QPixmap;
import io.qt.widgets.QApplication;
import io.qt.widgets.QPushButton;
import io.qt.widgets.QWidget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现异形窗口
 *
 * @author Iammm
 * @date 2023/11/20
 */
public class demo11 {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(demo11.class);

    /**
     * @param args 参数
     */
    public static void main(String[] args) {
        // 设置java.library.path属性，指定Qt的动态链接库
        System.setProperty("java.library.path", "C:\\Qt\\6.6.0\\msvc2019_64\\bin");
        // 初始化Qt应用程序
        QApplication.initialize(args);
        // 创建一个QWidget实例
        QWidget qWidget = new QWidget();
        // 创建一个QPixmap实例，指定图片路径
        QPixmap zheZhao = new QPixmap(":遮罩.png");
        // 创建一个QPushButton实例
        QPushButton button = new QPushButton(qWidget);
        // 设置按钮的掩码
        button.setMask(zheZhao.mask());
        // 设置按钮的位置和大小
        button.setGeometry(50, 50, zheZhao.width(), zheZhao.height());
        // 设置qWidget的掩码
        qWidget.setMask(zheZhao.mask());
        // 连接按钮的点击事件
        button.clicked.connect(e -> logger.info("clicked"));
        // 显示qWidget
        qWidget.show();
        // 执行Qt应用程序
        QApplication.exec();
    }
}


