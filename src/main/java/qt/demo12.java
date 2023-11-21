package qt;

import io.qt.core.QUrl;
import io.qt.multimedia.QMediaPlayer;
import io.qt.widgets.QApplication;
import io.qt.widgets.QWidget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现简单的媒体播放
 *
 * @author Iammm
 * @Time 2023/11/20 11:33
 */
public class demo12 {
    private Logger logger= LoggerFactory.getLogger(demo12.class);

    public static void main(String[] args) {
        System.setProperty("java.library.path", "C:\\Qt\\6.6.0\\msvc2019_64\\bin");
        QApplication.initialize(args);
        QWidget  widget=new musicPlayer();
widget.show();
QApplication.exec();


    }
}
