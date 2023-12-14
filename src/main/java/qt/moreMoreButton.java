package qt;

import io.qt.widgets.QApplication;
import io.qt.widgets.QHBoxLayout;
import io.qt.widgets.QPushButton;
import io.qt.widgets.QWidget;

/**
 * 生成更多按钮
 *
 * @author Iammm
 * @Time 2023/12/14 16:09
 */
public class moreMoreButton {
    public static void main(String[] args) {
        System.setProperty("java.library.path", "C:\\Qt\\6.6.0\\msvc2019_64\\bin");
        QApplication.initialize(args);
        var qw=new QWidget();
        var qh=new QHBoxLayout();
        mmmmmore(qw,25,qh);
        qw.setLayout(qh);
        qw.adjustSize();
        qw.show();
        QApplication.exec();
    }

    private static void mmmmmore(QWidget qw, int i, QHBoxLayout qh) {
        for (int i1 = 0; i1 < i; i1++) {
            var b=new QPushButton("mm"+i1,qw);
            int finalI = i1;
            b.clicked.connect(() ->{
                System.out.println(finalI);
            });
qh.addWidget(b);
            System.out.println(i1);
        }
    }
}
