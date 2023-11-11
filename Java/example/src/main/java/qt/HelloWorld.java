package qt;

/**
 * @author Iammm
 * @date 2023/10/25 18:39
 * @description qt hi world,qt sdk must use msvc!!!
 */
import io.qt.widgets.*;
public class HelloWorld {
    public static void main(String[] args) {
        QApplication.initialize(args);
        QMessageBox.information(null, "QtJambi", "Hello World!");
        QApplication.shutdown();
        new HelloWorld().go();
    }

    private void go() {
        QApplication.initialize(new String[]{});

    }
}