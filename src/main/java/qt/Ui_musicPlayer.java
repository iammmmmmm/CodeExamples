/********************************************************************************
 * Form generated from reading UI file 'musicPlayer.ui'
 *
 * Created by: QtJambi User Interface Compiler version 6.6.0
 *
 * WARNING! All changes made in this file will be lost when recompiling UI file!
 *******************************************************************************/

package qt;

import io.qt.NonNull;
import io.qt.core.*;
import io.qt.multimedia.QAudioOutput;
import io.qt.multimedia.QMediaPlayer;
import io.qt.widgets.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * UI音乐播放器
 *
 * @author iam
 * @date 2023/11/21
 */
public class Ui_musicPlayer {

    /**
     * 网格布局
     */
    public QGridLayout gridLayout;
    /**
     * 水平布局 2
     */
    public QHBoxLayout horizontalLayout_2;
    /**
     *
     */
    public QVBoxLayout verticalLayout_2;
    /**
     * 歌曲名称
     */
    public QLabel songName;
    /**
     * 垂直布局
     */
    public QVBoxLayout verticalLayout;
    /**
     *
     */
    public QSlider musicProgrammes;
    /**
     * 水平布局
     */
    public QHBoxLayout horizontalLayout;
    /**
     * 最后
     */
    public QPushButton last;
    /**
     * 模式
     */
    public QPushButton mode;
    /**
     * 玩
     */
    public QPushButton play;
    /**
     * 选择歌曲
     */
    public QPushButton selectSong;
    /**
     * 下一个
     */
    public QPushButton next;
    /**
     * 垂直布局 3
     */
    public QVBoxLayout verticalLayout_3;
    /**
     * 语音值滑块
     */
    public QSlider voiceValueSlider;
    /**
     *
     */
    public QLabel voiceValue;

    /**
     * 音乐播放器
     */
    public QMediaPlayer musicPlayer;

    /**
     * “Q 文件”对话框
     */
    QFileDialog qFileDialog;
    /**
     * 音乐长度
     */
    private int musicLength;
    /**
     * 音乐列表
     */
    private @NonNull QList<@NonNull QUrl> musicList;
    /**
     * 音乐索引
     */
    private int musicIndex = -1;
    /**
     * 日志
     */
    private Logger logger =
            LoggerFactory.getLogger(Ui_musicPlayer.class);
    /**
     * 播放模式
     */
    private String model = "顺序";
    /**
     * 模式文本
     */
    private String modeText = "mode: " + this.model;

    /**
     * 设置 UI
     *
     * @param musicPlayer 音乐播放器
     */
    public void setupUi(QWidget musicPlayer) {
        if (musicPlayer.objectName().isEmpty())
            musicPlayer.setObjectName("musicPlayer");
        musicPlayer.resize(492, 212);
        this.gridLayout = new QGridLayout(musicPlayer);
        this.gridLayout.setObjectName("gridLayout");
        this.horizontalLayout_2 = new QHBoxLayout();
        this.horizontalLayout_2.setObjectName("horizontalLayout_2");
        this.verticalLayout_2 = new QVBoxLayout();
        this.verticalLayout_2.setObjectName("verticalLayout_2");
        this.songName = new QLabel(musicPlayer);
        this.songName.setObjectName("songName");

        this.verticalLayout_2.addWidget(this.songName);
        this.verticalLayout = new QVBoxLayout();
        this.verticalLayout.setObjectName("verticalLayout");
        this.musicProgrammes = new QSlider(musicPlayer);
        this.musicProgrammes.setObjectName("musicProgrammes");
        this.musicProgrammes.setOrientation(Qt.Orientation.Horizontal);

        this.verticalLayout.addWidget(this.musicProgrammes);
        this.horizontalLayout = new QHBoxLayout();
        this.horizontalLayout.setObjectName("horizontalLayout");
        this.last = new QPushButton(musicPlayer);
        this.last.setObjectName("last");

        this.horizontalLayout.addWidget(this.last);
        this.mode = new QPushButton(musicPlayer);
        this.mode.setObjectName("mode");

        this.horizontalLayout.addWidget(this.mode);
        this.play = new QPushButton(musicPlayer);
        this.play.setObjectName("play");

        this.horizontalLayout.addWidget(this.play);
        this.selectSong = new QPushButton(musicPlayer);
        this.selectSong.setObjectName("selectSong");

        this.horizontalLayout.addWidget(this.selectSong);
        this.next = new QPushButton(musicPlayer);
        this.next.setObjectName("next");

        this.horizontalLayout.addWidget(this.next);

        this.verticalLayout.addLayout(this.horizontalLayout);

        this.verticalLayout_2.addLayout(this.verticalLayout);

        this.horizontalLayout_2.addLayout(this.verticalLayout_2);
        this.verticalLayout_3 = new QVBoxLayout();
        this.verticalLayout_3.setObjectName("verticalLayout_3");
        this.voiceValueSlider = new QSlider(musicPlayer);
        this.voiceValueSlider.setObjectName("voiceValueSlider");
        this.voiceValueSlider.setOrientation(Qt.Orientation.Vertical);

        this.verticalLayout_3.addWidget(this.voiceValueSlider);
        this.voiceValue = new QLabel(musicPlayer);
        this.voiceValue.setObjectName("voiceValue");

        this.verticalLayout_3.addWidget(this.voiceValue);

        this.horizontalLayout_2.addLayout(this.verticalLayout_3);

        this.gridLayout.addLayout(this.horizontalLayout_2, 0, 0, 1, 1);

        this.retranslateUi(musicPlayer);

        this.musicPlayer = new QMediaPlayer(musicPlayer);
        this.musicPlayer.setAudioOutput(new QAudioOutput(musicPlayer));

        QMetaObject.connectSlotsByName(musicPlayer);

        // 事件处理
        {
            this.musicPlayer.sourceChanged.connect(() -> {
                this.musicLength = Math.toIntExact(this.musicPlayer.duration() / 1000);
                this.musicProgrammes.setRange(0, this.musicLength);
                logger.info("musicLength:{}", this.musicLength);
            });
            this.musicPlayer.positionChanged.connect((position) -> {
                this.musicProgrammes.setValue(Math.toIntExact(this.musicPlayer.position() / 1000));
            });
            this.play.clicked.connect(() -> {
                if (this.musicIndex == -1) {
                    selectSong();
                } else {
                    if (this.musicPlayer.isPlaying()) {
                        this.musicPlayer.pause();
                        this.play.setText("播放");
                    } else {
                        this.musicPlayer.play();
                        this.play.setText("暂停");
                    }
                }
            });
            this.musicPlayer.mediaStatusChanged.connect(() -> {
                if (this.musicPlayer.mediaStatus() == QMediaPlayer.MediaStatus.EndOfMedia) {
                    songSwitching();
                }
            });
            this.next.clicked.connect(this::nextAndLast);
            this.last.clicked.connect(this::nextAndLast);
            this.musicPlayer.sourceChanged.connect(() ->
            {
                this.songName.setText(this.musicPlayer.source().fileName());
                logger.debug("songName:{}", this.musicPlayer.source().fileName());
            });
            this.selectSong.clicked.connect(this::selectSong);


        }
        ;


    }

    /**
     * 歌曲切换
     */
    private void songSwitching() {
//TODO 写玩这个破玩意，音量调整，播放模式，上/下首，
    }

    /**
     * 下一个和最后一个
     */
    private void nextAndLast() {

    }

    /**
     * 选择歌曲
     */
    private void selectSong() {
        this.qFileDialog = new QFileDialog();
        this.qFileDialog.setNameFilters(Collections.singleton("音乐文件(*.mp3 *.flac)"));
        this.qFileDialog.setAcceptMode(QFileDialog.AcceptMode.AcceptOpen);
        this.qFileDialog.show();
        this.qFileDialog.fileSelected.connect(e -> {
            this.musicPlayer.setSource(this.qFileDialog.selectedUrls().get(0));
            this.musicPlayer.play();
            this.play.setText("暂停");
            logger.info("开始播放");
            this.musicIndex = 0;
            logger.debug("musicIndex:{}", this.musicIndex);
            this.musicList = this.qFileDialog.selectedUrls();
            if (this.musicList.size() > 1) {
                this.next.setVisible(true);
                this.last.setVisible(true);
            } else {
                this.last.setVisible(false);
                this.next.setVisible(false);
            }
        });
    }

    /**
     * 重新翻译 UI
     *
     * @param musicPlayer 音乐播放器
     */
    public void retranslateUi(QWidget musicPlayer) {
        musicPlayer.setWindowTitle(io.qt.core.QCoreApplication.translate("musicPlayer", "音乐播放器", null));
        this.songName.setText(io.qt.core.QCoreApplication.translate("musicPlayer", "TextLabel", null));
        this.last.setText(io.qt.core.QCoreApplication.translate("musicPlayer", "\u4E0A\u4E00\u9996", null));
        this.mode.setText(io.qt.core.QCoreApplication.translate("musicPlayer", modeText, null));
        this.play.setText(io.qt.core.QCoreApplication.translate("musicPlayer", "播放", null));
        this.selectSong.setText(io.qt.core.QCoreApplication.translate("musicPlayer", "选择歌曲", null));
        this.next.setText(io.qt.core.QCoreApplication.translate("musicPlayer", "\u4E0B\u4E00\u9996", null));
        this.voiceValue.setText(io.qt.core.QCoreApplication.translate("musicPlayer", "\u97F3\u91CF", null));
    }
}

