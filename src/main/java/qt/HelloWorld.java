package qt;

/**
 * @author Iammm
 * @date 2023/10/25 18:39
 * qt hi world,qt sdk must use msvc!!!
 */

import io.qt.widgets.*;

public class HelloWorld {
    public static void main(String[] args) {
        System.setProperty("java.library.path", "C:\\Qt\\6.6.0\\msvc2019_64\\bin");
        QApplication.initialize(args);
        QMessageBox.information(null, "QtJambi", "Hello World!");
        QApplication.shutdown();
    }
}