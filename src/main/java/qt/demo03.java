package qt;

import io.qt.core.Qt;
import io.qt.widgets.*;

/**
 * 布局管理器
 *
 * @author Iammm
 * @date 2023/10/27 13:32
 */
public class demo03 {
    public static void main(String[] args) {
        System.setProperty("java.library.path", "C:\\Qt\\6.6.0\\msvc2019_64\\bin");

        QApplication.initialize(args);
        go();
        QApplication.exec();
    }

    static void go() {
//        new layout().noLayout();
        new layout().HAndVBox();


    }
}

class layout extends QWidget {
    String strNOLayout = "no Layout!";

    void noLayout() {
        QWidget parent = this;
        setWindowTitle("no layout");

        QLabel hi = new QLabel("hi world!", parent);
        hi.setToolTip(strNOLayout);
        hi.move(25, 25);
        QLabel hi2 = new QLabel("cnm world!", parent);
        hi2.setToolTip(strNOLayout);
        hi2.move(205, 215);
        QLabel hi3 = new QLabel("fk world!", parent);
        hi3.setToolTip(strNOLayout);
        hi3.move(105, 215);
        show();
    }

    void HAndVBox() {
        QWidget parent = this;
        QVBoxLayout vbox = new QVBoxLayout(parent);
        QHBoxLayout hbox = new QHBoxLayout(parent);
        setWindowTitle("HAndVBoxLayout");
        QPushButton qb1 = new QPushButton("click me", parent);
        QPushButton qb2 = new QPushButton("do not click mew", parent);
        hbox.addWidget(qb1, 0, Qt.AlignmentFlag.AlignLeft);
        hbox.addWidget(qb2, 0, Qt.AlignmentFlag.AlignRight);
        vbox.addStretch(0);

        vbox.addLayout(hbox);


        show();
    }

}