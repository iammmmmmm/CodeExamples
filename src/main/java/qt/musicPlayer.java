package qt;

public class musicPlayer extends io.qt.widgets.QWidget {

    private final Ui_musicPlayer ui = new Ui_musicPlayer();

    public musicPlayer() {
        super();
        ui.setupUi(this);
    }

    public musicPlayer(io.qt.widgets.QWidget arg0) {
        super(arg0);
        ui.setupUi(this);
    }

    public musicPlayer(io.qt.widgets.QWidget arg0, io.qt.core.Qt.WindowFlags arg1) {
        super(arg0, arg1);
        ui.setupUi(this);
    }

    public musicPlayer(io.qt.widgets.QWidget arg0, io.qt.core.Qt.WindowType... arg1) {
        super(arg0, arg1);
        ui.setupUi(this);
    }

    @Override
    protected void changeEvent(io.qt.core.QEvent e) {
        super.changeEvent(e);
        switch (e.type()) {
        case LanguageChange: ui.retranslateUi(this); break;
        default: break;
        }
    }
}
