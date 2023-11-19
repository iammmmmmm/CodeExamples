package qt;

import io.qt.core.QSize;
import io.qt.gui.QWindow;
import io.qt.widgets.QApplication;
import io.qt.widgets.QPushButton;
import io.qt.widgets.QWidget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

/**
 * 完整ui（非对话框）世界你好！and 一些例子
 *
 * @author Iammm
 * @date 2023/10/26 17:10
 */
public class dem02 {
    /**
     * 任何qt代码都必须在
     * QApplication.initialize(args);
     * \r\n// is here
     * QApplication.exec();
     * 这两句代码中间
     */
    public static void main(String[] args) {
        QApplication.initialize(args);
        new myapp().go();
        ttest();
        // 实现窗口居中
        new myapp().Centerwindow();
        // 添加按钮
        new myapp().addAButton();
        // 为按钮添加自定义事件处理
        new myapp().addAButtonWithMyMethod();
        QApplication.exec();
    }

    private static void ttest() {
        QWindow qWindow = new QWindow();
        qWindow.setTitle("Hello Qt&world");
        qWindow.setMinimumSize(new QSize(500, 500));
        qWindow.show();
    }
}

/**
 * myapp类继承自QWidget，实现了自定义窗口
 *
 * @author Iammm
 * @date 2023/10/26 17:10
 */
class myapp extends QWidget {
    Logger log = LoggerFactory.getLogger(myapp.class);

    void go() {
        // 设置窗口标题
        setWindowTitle("Hello Qt&world");
        // 设置窗口提示
        setToolTip("Hello world");
        // 设置窗口大小
        resize(500, 500);
        // 打印日志
        log.debug("zzZZZ");
        try {
            // 暂停2秒
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 打印日志
        log.debug("oOOOO00");
        // 显示窗口
        show();
    }

    void Centerwindow() {
        /**
         * 设置窗口标题
         * @param title 窗口标题
         */
        setWindowTitle("窗口居中");

/**
 * 设置窗口提示
 * @param tip 窗口提示
 */
        setToolTip("窗口居中");

        int width = 250;
        int height = 250;
        // 设置窗口大小的最值
        setMinimumSize(width, height);
        setMaximumSize(width + 20, height + 20);

// 将窗口移动到屏幕的中心位置
        // 不调用move方法默认就在中央
        // move();
// 显示窗口
        show();

    }

    void addAButton() {
        /**
         * 设置窗口标题
         * @param title 窗口标题
         */
        setWindowTitle("exit button");

// 创建一个QPushButton对象，设置文本为"exit"
        QPushButton qPushButton = new QPushButton("exit");

// 将QPushButton添加为当前窗口的子控件
        qPushButton.setParent(this);

// 设置QPushButton的位置、大小等属性
        qPushButton.setGeometry(30, 30, 75, 30);

// 将QPushButton的clicked信号与quit函数进行连接
        qPushButton.clicked.connect(QApplication.instance(), "quit");

// 设置窗口的大小
        resize(250, 150);

// 显示窗口
        show();

    }

    void addAButtonWithMyMethod() {
        /**
         * 设置窗口标题
         * @param title 窗口标题
         */
        setWindowTitle("exit button");

// 创建一个QPushButton对象，设置文本为"exit"
        QPushButton qPushButton = new QPushButton("click me");

// 将QPushButton添加为当前窗口的子控件
        qPushButton.setParent(this);

// 设置QPushButton的位置、大小等属性
        qPushButton.setGeometry(30, 30, 75, 30);

// 为按钮添加事件处理

        qPushButton.clicked.connect(this, "myM()");
        // 为按钮添加提示
        qPushButton.setToolTip("click me!!!!!!!!!");


// 设置窗口的大小
        resize(250, 150);

// 显示窗口
        show();

    }

    void myM() {
        log.debug("myM");
    }
}
