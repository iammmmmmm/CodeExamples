package qt;


import io.qt.core.Qt;
import io.qt.gui.QBrush;
import io.qt.gui.QPalette;
import io.qt.gui.QPixmap;
import io.qt.widgets.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/** 屏幕贴图
 * @author Iammm
 * @date 2023/11/7 17:26
 *
 */
public class demo06 {

    public static void main(String[] args) {
        QApplication.initialize(args);
        new myGUI();
        QApplication.exec();
    }

}

//Class to create a GUI for the application
class myGUI extends QWidget {
    //Logger to log messages
    private static Logger logger = LoggerFactory.getLogger(myGUI.class);
    //Parent widget
    private final QWidget parent = this;
    //File dialog to open images
    private QFileDialog qFileDialog = new QFileDialog(parent, "选择图片", "./");
    //Label to show the image
    private QLabel preview=new QLabel(parent);
    //Label to show the transparency slider
    private QLabel setTransparency =new QLabel("透明度", parent);
    //Slider to adjust the transparency
    private QSlider TransparencySlider = new QSlider(parent);
    //Variable to store the current transparency
    private double transparency=100;
    //Variable to store the path of the image
    private String picPathName = null;
    //Variable to store the QPixmap of the image
    private QPixmap stickers;
    //Label to show the current transparency
    private QLabel previewTransparency=new QLabel(parent);
    //Button to show the image on the screen
    private QPushButton showPic=new QPushButton("在屏幕上显示贴图", parent);
    //Widget to contain the image
    private QWidget picWidget=new QWidget();
    //Variables to store the width and height of the screen
    private int screenW=1000, screenH=1000;

    //Method to create the GUI
    public myGUI() {
        //Set the window title
        setWindowTitle("屏幕贴图");
        //Set the window size
        setGeometry(0, 0,750,550);
        //Create a button to open an image
        QPushButton openPic = new QPushButton("打开图片", parent);
        openPic.setGeometry(1, 1, 100, 50);
        //Connect the button to the openPic method
        openPic.clicked.connect(this, "openPic()");
        //Set the label for the transparency slider
        setTransparency.setGeometry(1,55,100,50);
        //Create the slider for the transparency
        TransparencySlider.setGeometry(10,110,10,100);
        //Set the range of the slider
        TransparencySlider.setRange(0,100);
        //Set the default value of the slider
        TransparencySlider.setValue(100);
        //Set the tooltip of the slider
        TransparencySlider.setToolTip("可以鼠标放上去用滚轮调节呦~~");
        //Connect the slider to the setTransparency method
        TransparencySlider.valueChanged.connect(this, "setTransparency()");
        //Set the geometry of the preview label
        preview.setGeometry(105, 1, 500, 500);
        //Set the geometry of the previewTransparency label
        previewTransparency.setGeometry(45,55,30,50);
        //Set the text of the previewTransparency label
        previewTransparency.setText(String.valueOf(transparency));
        //Show the window
        show();
        //Set the geometry of the showPic button
        showPic.setGeometry(105,1,105,50);
        //Connect the button to the showPic method
        showPic.clicked.connect(this,"showPic()");
    }
    //Method to show the image on the screen
    private void showPic(){
        //Check if the image path is null
        if (picPathName==null){
            return;
        }
        //Hide the window
        setVisible(false);
        //设置窗口标题
        //Set the window title
        picWidget.setWindowTitle("屏幕贴图");
        //设置窗口大小
        //Set the window size
        picWidget.setFixedSize(stickers.width(), stickers.height());
//        //设置窗口sticky属性，保持窗口始终置顶
        picWidget.setWindowFlags(Qt.WindowType.WindowStaysOnTopHint);
        //picWidget.setWindowFlags(Qt.WindowType.WindowStaysOnTopHint);
        //设置窗口背景透明，用于鼠标悬停显示窗口内容
        picWidget.setAttribute(Qt.WidgetAttribute.WA_TransparentForMouseEvents, true);
        //设置窗口无边框
        picWidget.setWindowFlag(Qt.WindowType.FramelessWindowHint);
        //设置窗口透明度
        picWidget.setWindowOpacity(transparency);
        //设置窗口全屏显示
//       picWidget.setWindowState(Qt.WindowState.WindowFullScreen);
        QPalette palette= picWidget.getPalette();
        //Set the background of the widget to the image
        palette.setBrush(QPalette.ColorRole.Window,new QBrush(stickers));
        picWidget.setPalette(palette);
        //Show the widget
        picWidget.show();
    }

    //Method to set the transparency
    private void setTransparency(){
        //Set the current transparency
        transparency  =TransparencySlider.value()*0.01;
        //Log the current transparency
        logger.debug("设置透明度："+transparency);
        //Create a QGraphicsOpacityEffect
        QGraphicsOpacityEffect qe=new QGraphicsOpacityEffect(this);
        //Set the opacity of the effect
        qe.setOpacity(transparency);
        //Set the effect to the preview label
        preview.setGraphicsEffect(qe);
        //Set the text of the previewTransparency label
        previewTransparency.setText(String.valueOf(transparency));
    }


    //Method to open an image
    private void openPic() {
        //Set the view mode of the file dialog
        qFileDialog.setViewMode(QFileDialog.ViewMode.Detail);
        //Set the filters of the file dialog
        qFileDialog.setNameFilters(Collections.singleton("图片文件(*.png *.jpg *.bmp)"));
        //Set the accept mode of the file dialog
        qFileDialog.setAcceptMode(QFileDialog.AcceptMode.AcceptOpen);
        //Show the file dialog
        qFileDialog.show();
        //Connect the file selected signal to the setPixmap method
        qFileDialog.fileSelected.connect(this, "setPixmap()");
    }

    //Method to set the pixmap
    private void setPixmap() {
        //Get the path of the image
        picPathName=qFileDialog.selectedFiles().get(0);
        //Log the path of the image
        logger.debug("选择了：{}", picPathName);
        //Create a QPixmap from the image
        stickers = new QPixmap(picPathName);
        //Set the pixmap to the preview label
        preview.setPixmap(stickers.scaled(500, 500, Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        //Show the preview label`
        preview.show();
    }

}