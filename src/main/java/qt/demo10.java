package qt;

import io.qt.widgets.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import slf4j.HelloWorld;

/**
 * 演示10自定义qt信号，和槽
 *
 * @author Iammm
 * @date 2023/11/18 18:47
 */


public class demo10 {
    /**
     * 记录
     */
    private final static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    /**
     * 主要
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        System.setProperty("java.library.path", "C:\\Qt\\6.6.0\\msvc2019_64\\bin");
        logger.info("qt dll  loaded");
        QApplication.initialize(args);
        demo10.ui();
        QApplication.exec();
    }

    /**
     * 用户界面
     */
    private static void ui() {
        QWidget widget = new QWidget();
        widget.setWindowTitle("Hello World");
        widget.resize(800, 600);
        aQlabel label = new aQlabel(widget);
        label.setText("Hello World");
        label.setGeometry(10, 10, 200, 200);
        aQPushButton button = new aQPushButton(widget);
        button.setText("click me");
        button.setGeometry(10, 10, 50, 50);
        button.clickedMe.connect(label::mySetText);
        aQTextEdit qTextEdit = new aQTextEdit(widget);
        qTextEdit.setGeometry(300, 10, 200, 200);
        // 此处需与上方同名槽做区分
        // 后果自己试
        qTextEdit.textChanged.connect(label, "mySetText(String)");
        widget.show();

    }
}

class aQlabel extends QLabel {
    // defining signals in Java
    public final Signal0 started = new Signal0();
    private final Logger logger = LoggerFactory.getLogger(whatsThis());

    public aQlabel(QWidget qWidget) {
        super(qWidget);
        this.started.emit();
    }

    // defining slots

    void mySetText(String text) {
        super.setText(text + "_by_my_Set_Text!");
        logger.info("text changed");
    }

    void mySetText() {
        super.setText("text" + "_by_my_Set_Text!");
        logger.info("text changed!@!");
    }


}

/**
 * QPus按钮
 *
 * @author admin
 * @date 2023/11/19
 */
class aQPushButton extends QPushButton {
    /**
     * 点击我
     */
    public final Signal0 clickedMe = new Signal0();
    /**
     * 日志
     */
    private final Logger logger = LoggerFactory.getLogger(whatsThis());

    /**
     * QPus按钮
     *
     * @param qWidget Q 小部件
     */
    public aQPushButton(QWidget qWidget) {
        super(qWidget);
        super.clicked.connect(clickedMe::emit);
    }

}

/**
 * QText 编辑
 *
 * @author admin
 * @date 2023/11/19
 */
class aQTextEdit extends QTextEdit {
    /**
     * 文本已更改
     */
    public final Signal1<String> textChanged = new Signal1<>();

    /**
     * QText 编辑
     *
     * @param widget 控件
     */
    public aQTextEdit(QWidget widget) {
        super(widget);
        super.textChanged.connect(() -> textChanged.emit(super.toPlainText()));
    }
}