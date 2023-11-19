package qt;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import io.qt.core.Qt;
import io.qt.gui.QPixmap;
import io.qt.widgets.*;

/**
 * 异形窗口以及窗口样式，鼠标穿透，还有全局快捷键
 *
 * @author Iammm
 * @date 2023/10/28 14:09
 */
public class demo04 {
    public static void main(String[] args) {
        QApplication.initialize(args);
        new windowFlag().run();
        QApplication.exec();

    }
}

class windowFlag extends QWidget {
    void run() {
        //  mousePenetration();
        onTop();
//        Alien();
    }

    void Alien() {
// TODO 实现异形窗口
// 我有空会写的，有空一定(/▽＼)
    }

    static final int WA_TransparentForMouseEvents_OFF_ON = 0;
    HotkeyListener hotkeyListener = null;
    static boolean on_off = true;

    void onTop() {
        // 设置置顶
        setWindowFlags(Qt.WindowType.WindowStaysOnTopHint);
        // 设置鼠标穿透
        setAttribute(Qt.WidgetAttribute.WA_TransparentForMouseEvents, on_off);
        // 设置无边框以及最小化最大化关闭按钮
        setWindowFlag(Qt.WindowType.FramelessWindowHint);
        // 设置窗口背景透明
        setAttribute(Qt.WidgetAttribute.WA_TranslucentBackground);
        // 设置窗口全屏显示
        setWindowState(Qt.WindowState.WindowFullScreen);
        QWidget parent = this;
        setWindowTitle("no layout");

        QLabel hi = new QLabel("hi world!", parent);
        hi.setToolTip("strNOLayout");
        hi.move(25, 25);
        QLabel hi2 = new QLabel("cnm world!", parent);
        hi2.setToolTip("strNOLayout");
        hi2.move(205, 215);
        QLabel hi3 = new QLabel("fk world!", parent);
        hi3.setToolTip("strNOLayout");
        hi3.move(105, 215);
        show();
        JIntellitype.getInstance().registerHotKey(WA_TransparentForMouseEvents_OFF_ON,
                JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT, 'L'); // ctrl + ALT + L

        hotkeyListener = c -> {
            System.out.println("快捷键被触发");

            switch (c) {
                case WA_TransparentForMouseEvents_OFF_ON -> {
                    if (on_off) {
                        on_off = false;
                    } else {
                        on_off = true;
                    }
                    setAttribute(Qt.WidgetAttribute.WA_TransparentForMouseEvents, on_off);
                }

            }
        };
        JIntellitype.getInstance().addHotKeyListener(hotkeyListener); // 添加监听
    }

    void mousePenetration() {


        setMaximumSize(1000, 1000);
        setMinimumSize(1000, 1000);
        setWindowTitle("mouse");
        setToolTip("mouse");
        setAttribute(Qt.WidgetAttribute.WA_TransparentForMouseEvents, true);
        setWindowFlag(Qt.WindowType.FramelessWindowHint);
        setAttribute(Qt.WidgetAttribute.WA_TranslucentBackground);
        QWidget parent = this;
        QVBoxLayout vbox = new QVBoxLayout(parent);
        QHBoxLayout hbox = new QHBoxLayout(parent);
        QPushButton qb1 = new QPushButton("click me", parent);
        QPushButton qb2 = new QPushButton("do not click mew", parent);
        QPixmap qPixmap = new QPixmap("Java/example/src/main/resources/wallhaven-6dykgx.png");
        QLabel qLabel = new QLabel(parent);
        qLabel.setPixmap(qPixmap);
        hbox.addWidget(qb1, 0, Qt.AlignmentFlag.AlignLeft);
        hbox.addWidget(qb2, 0, Qt.AlignmentFlag.AlignRight);
        hbox.addWidget(qLabel, 0, Qt.AlignmentFlag.AlignRight);
        vbox.addStretch(0);
        vbox.addLayout(hbox);


        show();
    }

}
