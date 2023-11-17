package qt.demo09;

public class demo07 extends io.qt.widgets.QWidget {

    private final Ui_demo07 ui = new Ui_demo07();

    public demo07() {
        super();
        ui.setupUi(this);
    }

    public demo07(io.qt.widgets.QWidget arg0) {
        super(arg0);
        ui.setupUi(this);
    }

    public demo07(io.qt.widgets.QWidget arg0, io.qt.core.Qt.WindowFlags arg1) {
        super(arg0, arg1);
        ui.setupUi(this);
    }

    public demo07(io.qt.widgets.QWidget arg0, io.qt.core.Qt.WindowType... arg1) {
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
