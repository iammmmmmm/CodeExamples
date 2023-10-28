package qt;

import io.qt.core.QPoint;
import io.qt.core.Qt;
import io.qt.gui.*;
import io.qt.widgets.*;

import java.util.Objects;

/**
 * @author Iammm
 * @date 2023/10/28 14:09
 * @description 异形窗口以及窗口样式，鼠标穿透
 */
public class demo04 {
    public static void main(String[] args) {
        QApplication.initialize(args);
        new windowFlag().run();
        QApplication.exec();

    }
}

class windowFlag extends QWidget {
    void run() {
        mousePenetration();
    }

    void mousePenetration() {



        setMaximumSize(1000, 1000);
        setMinimumSize(1000, 1000);
        setWindowTitle("mouse");
        setToolTip("mouse");
        setAttribute(Qt.WidgetAttribute.WA_TransparentForMouseEvents, true);
        setWindowFlag(Qt.WindowType.FramelessWindowHint);
        setAttribute(Qt.WidgetAttribute.WA_TranslucentBackground);
        QWidget parent = this;
        QVBoxLayout vbox = new QVBoxLayout(parent);
        QHBoxLayout hbox = new QHBoxLayout(parent);
        QPushButton qb1 = new QPushButton("click me", parent);
        QPushButton qb2 = new QPushButton("do not click mew", parent);
        QPixmap qPixmap = new QPixmap("Java/example/src/main/resources/wallhaven-6dykgx.png");
        QLabel qLabel = new QLabel(parent);
        qLabel.setPixmap(qPixmap);
        hbox.addWidget(qb1, 0, Qt.AlignmentFlag.AlignLeft);
        hbox.addWidget(qb2, 0, Qt.AlignmentFlag.AlignRight);
        hbox.addWidget(qLabel, 0, Qt.AlignmentFlag.AlignRight);
        vbox.addStretch(0);
        vbox.addLayout(hbox);


        show();
    }

    @Override
    protected void paintEvent(QPaintEvent event) {

        QPainter painter = new QPainter(this);
        drawLyrics(painter);

    }

    private void drawLyrics(QPainter painter) {

        painter.setBrush(new QColor(25, 25, 25));
        painter.setFont(new QFont("Purisa", 100));

        painter.drawText(new QPoint(20, 30),
                "Most relationships seem so transitory");
        painter.drawText(new QPoint(20, 60),
                "They're good but not the permanent one");
        painter.drawText(new QPoint(20, 120),
                "Who doesn't long for someone to hold");
        painter.drawText(new QPoint(20, 150),
                "Who knows how to love without being told");
        painter.drawText(new QPoint(20, 180),
                "Somebody tell me why I'm on my own");
        painter.drawText(new QPoint(20, 210),
                "If there's a soulmate for everyone");
    }

}
