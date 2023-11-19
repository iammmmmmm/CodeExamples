package qt.demo09;

import io.qt.widgets.QApplication;
import io.qt.widgets.QWidget;

/**
 调用从.ui转到java的界面、

 * @author Iammm
 * @date 2023/11/17 17:17
 */
public class demo09 {
    public static void main(String[] args) {
        System.setProperty("java.library.path", "C:\\Qt\\6.6.0\\msvc2019_64\\bin");
        QApplication.initialize(args);
        QWidget qWidget= new demo07();
        qWidget.show();
        QApplication.exec();
    }
}
