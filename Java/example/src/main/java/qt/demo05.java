package qt;

import io.qt.core.QAbstractAnimation;
import io.qt.core.QUrl;
import io.qt.core.Qt;
import io.qt.gui.QPicture;
import io.qt.gui.QPixmap;
import io.qt.multimedia.QAudio;
import io.qt.multimedia.QAudioFormat;
import io.qt.multimedia.QAudioOutput;
import io.qt.multimedia.QMediaPlayer;
import io.qt.multimedia.widgets.QVideoWidget;
import io.qt.widgets.QApplication;
import io.qt.widgets.QLabel;
import io.qt.widgets.QSplitter;
import io.qt.widgets.QWidget;

/**
 * @author Iammm
 * @date 2023/11/1 16:02
 * @description 媒体相关，显示图片，播放音视频
 */
public class demo05 {
    public static void main(String[] args) {
        QApplication.initialize(args);
        new media().run();
        QApplication.exec();
    }


}

class media extends QWidget {

    public media() {
        //设置窗口标题
        setWindowTitle("媒体");
        //设置窗口大小
        setFixedSize(1500, 500);
        //设置窗口sticky属性，保持窗口始终置顶
        setWindowFlags(Qt.WindowType.WindowStaysOnTopHint);
        //设置窗口背景透明，用于鼠标悬停显示窗口内容
        setAttribute(Qt.WidgetAttribute.WA_TransparentForMouseEvents, true);
        //设置窗口无边框
        setWindowFlag(Qt.WindowType.FramelessWindowHint);
        //设置窗口透明度
        setWindowOpacity(0.5f);
//        //设置窗口全屏显示
//        setWindowState(Qt.WindowState.WindowFullScreen);
    }

    void run() {


        QWidget parent = this;

        // 创建一个QLabel对象，用于显示图片
        QLabel qLabel = new QLabel(parent);

        // 加载图片
        QPixmap qPixmap = new QPixmap("src/main/resources/fd52ac76a3dd75bebfa9370bf6a2769520e6b336.jpg");

        // 使用scaled进行图片缩放
        qLabel.setPixmap(qPixmap.scaled(500, 500, Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));  // 按比例缩放

        // 设置图片位置和大小
        qLabel.setGeometry(0, 0, 500, 500);

        // 创建一个QLabel对象，用于显示图片
        QLabel qLabel1 = new QLabel(parent);

        // 设置图片位置和大小
        qLabel1.setGeometry(500, 0, 500, 500);

        // 使用setScaledContents让图像适应label
        qLabel1.setScaledContents(true);

        // 创建一个QMediaPlayer对象，用于播放音频文件
        QMediaPlayer qm = new QMediaPlayer(parent);

        // 创建一个QAudioOutput对象，用于播放音频文件
        QAudioOutput qAudio = new QAudioOutput();

        // 设置QMediaPlayer的音频输出为QAudioOutput
        qm.setAudioOutput(qAudio);

        // 设置QMediaPlayer的源为音频文件URL
        qm.setSource(new QUrl("src/main/resources/飘向北方-那吾克热-NW&尤长靖-.mp3"));

        // 播放音频文件
        qm.play();










        // 显示窗口
        show();



    }


}