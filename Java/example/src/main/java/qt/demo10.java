package qt;

import io.qt.core.QObject;
import io.qt.widgets.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import slf4j.HelloWorld;

/**
 * @author Iammm
 * @date 2023/11/18 18:47
 * @description 自定义qt信号
 */
public class demo10 {
    private final static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        System.setProperty("java.library.path", "C:\\Qt\\6.6.0\\msvc2019_64\\bin");
        logger.info("qt dll  loaded");
        QApplication.initialize(args);
        demo10.ui();
        QApplication.exec();
    }

    private static void ui() {
        QWidget widget = new QWidget();
        widget.setWindowTitle("Hello World");
        widget.resize(800, 600);
        aQlabel label = new aQlabel(widget);
        label.setText("Hello World");
        label.setGeometry(10,10,200,200);
        aQPushButton button = new aQPushButton(widget);
        button.setText("click me");
        button.setGeometry(10,10,50,50);
        button.clickedMe.connect(label::mySetText);
        aQTextEdit qTextEdit = new aQTextEdit(widget);
        qTextEdit.setGeometry(300,10,200,200);
        //此处需与上方同名槽做区分
        //后果自己试
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

class aQPushButton extends QPushButton {
    public final Signal0 clickedMe = new Signal0();
    private final Logger logger = LoggerFactory.getLogger(whatsThis());

    public aQPushButton(QWidget qWidget) {
        super(qWidget);
        super.clicked.connect(clickedMe::emit);
    }

}

class aQTextEdit extends QTextEdit {
    public final Signal1<String> textChanged = new Signal1<String>();

    public aQTextEdit(QWidget widget) {
        super(widget);
        super.textChanged.connect(() -> textChanged.emit(super.toPlainText()));
    }
}