module codeexamples.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires annotations;
    requires com.sun.jna.platform;
    requires com.sun.jna;
    requires javafx.swing;

    opens codeexamples.jfx to javafx.fxml;
    exports codeexamples.jfx;
    exports demo.JnaGUNJavaFx to javafx.graphics;
    exports demo.rxControl to javafx.graphics;
    opens demo to javafx.fxml;
    exports demo;

}