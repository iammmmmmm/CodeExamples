/********************************************************************************
 * Form generated from reading UI file 'demo07.ui'
 * <p>
 * Created by: QtJambi User Interface Compiler version 6.6.0
 * <p>
 * WARNING! All changes made in this file will be lost when recompiling UI file!
 *******************************************************************************/

package qt.demo09;

import io.qt.core.*;
import io.qt.widgets.*;


public class Ui_demo07 {

    public QPushButton pushButton;
    public QDoubleSpinBox doubleSpinBox;
    public QComboBox comboBox;
    public QPlainTextEdit plainTextEdit;
    public QTimeEdit timeEdit;
    public QDateEdit dateEdit;
    public QSlider horizontalSlider;
    public QSlider verticalSlider;
    public QLCDNumber lcdNumber;
    public QCalendarWidget calendarWidget;
    public QKeySequenceEdit keySequenceEdit;
    public QDial dial;
    public QLineEdit lineEdit;
    public QFontComboBox fontComboBox;
    public QScrollBar horizontalScrollBar;
    public QScrollBar verticalScrollBar;

    public void setupUi(QWidget demo07) {

        if (demo07.objectName().isEmpty())
            demo07.setObjectName("demo07");
        demo07.setWindowModality(Qt.WindowModality.NonModal);
        demo07.resize(661, 422);
        this.pushButton = new QPushButton(demo07);
        this.pushButton.setObjectName("pushButton");
        this.pushButton.setGeometry(new QRect(10, 10, 75, 24));
        this.doubleSpinBox = new QDoubleSpinBox(demo07);
        this.doubleSpinBox.setObjectName("doubleSpinBox");
        this.doubleSpinBox.setGeometry(new QRect(10, 40, 62, 22));
        this.comboBox = new QComboBox(demo07);
        this.comboBox.setObjectName("comboBox");
        this.comboBox.setGeometry(new QRect(10, 70, 68, 22));
        this.plainTextEdit = new QPlainTextEdit(demo07);
        this.plainTextEdit.setObjectName("plainTextEdit");
        this.plainTextEdit.setGeometry(new QRect(10, 100, 104, 71));
        this.timeEdit = new QTimeEdit(demo07);
        this.timeEdit.setObjectName("timeEdit");
        this.timeEdit.setGeometry(new QRect(0, 180, 118, 22));
        this.dateEdit = new QDateEdit(demo07);
        this.dateEdit.setObjectName("dateEdit");
        this.dateEdit.setGeometry(new QRect(0, 210, 110, 22));
        this.horizontalSlider = new QSlider(demo07);
        this.horizontalSlider.setObjectName("horizontalSlider");
        this.horizontalSlider.setGeometry(new QRect(0, 240, 160, 16));
        this.horizontalSlider.setOrientation(Qt.Orientation.Horizontal);
        this.verticalSlider = new QSlider(demo07);
        this.verticalSlider.setObjectName("verticalSlider");
        this.verticalSlider.setGeometry(new QRect(130, 70, 16, 160));
        this.verticalSlider.setOrientation(Qt.Orientation.Vertical);
        this.lcdNumber = new QLCDNumber(demo07);
        this.lcdNumber.setObjectName("lcdNumber");
        this.lcdNumber.setGeometry(new QRect(90, 10, 64, 23));
        this.calendarWidget = new QCalendarWidget(demo07);
        this.calendarWidget.setObjectName("calendarWidget");
        this.calendarWidget.setGeometry(new QRect(180, 40, 248, 183));
        this.keySequenceEdit = new QKeySequenceEdit(demo07);
        this.keySequenceEdit.setObjectName("keySequenceEdit");
        this.keySequenceEdit.setGeometry(new QRect(20, 260, 113, 20));
        this.dial = new QDial(demo07);
        this.dial.setObjectName("dial");
        this.dial.setGeometry(new QRect(20, 300, 50, 64));
        this.lineEdit = new QLineEdit(demo07);
        this.lineEdit.setObjectName("lineEdit");
        this.lineEdit.setGeometry(new QRect(160, 260, 113, 20));
        this.fontComboBox = new QFontComboBox(demo07);
        this.fontComboBox.setObjectName("fontComboBox");
        this.fontComboBox.setGeometry(new QRect(50, 290, 223, 22));
        this.horizontalScrollBar = new QScrollBar(demo07);
        this.horizontalScrollBar.setObjectName("horizontalScrollBar");
        this.horizontalScrollBar.setGeometry(new QRect(10, 370, 160, 16));
        this.horizontalScrollBar.setOrientation(Qt.Orientation.Horizontal);
        this.verticalScrollBar = new QScrollBar(demo07);
        this.verticalScrollBar.setObjectName("verticalScrollBar");
        this.verticalScrollBar.setGeometry(new QRect(430, 50, 16, 160));
        this.verticalScrollBar.setOrientation(Qt.Orientation.Vertical);

        this.retranslateUi(demo07);
        this.verticalSlider.valueChanged.connect(this.doubleSpinBox::stepUp);
        this.dateEdit.userDateChanged.connect(this.calendarWidget::setSelectedDate);
        this.dial.valueChanged.connect(this.horizontalScrollBar::setValue);

        QMetaObject.connectSlotsByName(demo07);
    }

    public void retranslateUi(QWidget demo07) {
        demo07.setWindowTitle(io.qt.core.QCoreApplication.translate("demo07", "Form", null));
        this.pushButton.setText(io.qt.core.QCoreApplication.translate("demo07", "PushButton", null));
    }
}

