package qt;

import io.qt.core.QUrl;
import io.qt.core.Qt;
import io.qt.gui.QPixmap;
import io.qt.multimedia.QAudioOutput;
import io.qt.multimedia.QMediaPlayer;
import io.qt.multimedia.widgets.QVideoWidget;
import io.qt.widgets.QApplication;
import io.qt.widgets.QLabel;
import io.qt.widgets.QWidget;

/*媒体相关，显示图片，播放音视频
  @author Iammm
 * @date 2023/11/1 16:02
 *
 */

/**
 * 这是一个使用Java语言编写的Qt应用程序，用于显示图片、播放音频和视频。在这个例子中，我们创建了两个QLabel对象，一个用于显示图片
 * ，一个用于显示音频播放进度。我们还创建了一个QMediaPlayer对象和一个QAudioOutput对象，用于播放音频文件。
 * 请注意，这个例子中使用了Java的Qt绑定库，因此需要使用Java编译器进行编译。同时，这个例子中使用了Java的类路径，因此需要在运行时指定正确的类路径。
 *
 * @author 36077
 * @date 2023/11/19
 */
public class demo05 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        QApplication.initialize(args);
        new media().run();
        QApplication.exec();
    }


}

class media extends QWidget {

    /**
     *
     */
    public media() {
        //设置窗口标题
        setWindowTitle("媒体");
        //设置窗口大小
        setFixedSize(1500, 1000);
        //设置窗口sticky属性，保持窗口始终置顶
        setWindowFlags(Qt.WindowType.WindowStaysOnTopHint);
        //设置窗口背景透明，用于鼠标悬停显示窗口内容
        setAttribute(Qt.WidgetAttribute.WA_TransparentForMouseEvents, true);
        //设置窗口无边框
        setWindowFlag(Qt.WindowType.FramelessWindowHint);
        //设置窗口透明度
        setWindowOpacity(1f);
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

        qLabel1.setPixmap(qPixmap);

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
//        qm.play();
//TODO 为视频和音频播放添加进度条

        QLabel musicLabel=new QLabel(parent);
        musicLabel.setText(qm.duration()+"ms");
        musicLabel.setGeometry(1000,50,500,50);

        QMediaPlayer qM1=new QMediaPlayer(parent);
        qM1.setSource(new QUrl("src/main/resources/飘向北方mv.mp4"));
      QVideoWidget qVideoWidget=new QVideoWidget(parent);
      qM1.setVideoOutput(qVideoWidget);
      qM1.setAudioOutput(qAudio);
      qVideoWidget.setGeometry(0,500,250,250);
qM1.play();
        // 显示窗口
        show();

    }




}