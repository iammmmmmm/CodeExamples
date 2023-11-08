package qt;

import io.qt.core.QFile;
import io.qt.core.QIODevice;
import io.qt.widgets.QApplication;
import io.qt.widgets.QWidget;
import io.qt.widgets.tools.QUiLoader;

/**
 * @author Iammm
 * @date 2023/11/8 11:34
 * @description 使用qt自带的可视化ui设计软件设计ui
 */
public class demo07 {
    public static void main(String[] args) {
        QApplication.initialize(args);
        QUiLoader loader = new QUiLoader();
        QFile device = new QFile(":/demo07.ui");
        device.open(QIODevice.OpenModeFlag.ReadOnly);
        QWidget widget = loader.load(device);
        if (widget != null) {
            widget.show();
        }
        device.close();
        QApplication.exec();
    }
}
