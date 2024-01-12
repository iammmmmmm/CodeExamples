package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * css demo
 *
 * @author Iammm
 * @Time 2023/12/22 17:13
 */
public class CssDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        var vbox = new VBox();
        var sc = new Scene(vbox);
        Button b = new Button("sss");
        b.setId("myButton");
        vbox.getChildren().add(b);
        sc.getStylesheets().add(String.valueOf(this.getClass().getResource("cssDemo.css")));
        b.getStyleClass().add("myButton");
        vbox.getStyleClass().add("myVBox");
        Label label=new Label("ssssssssssssssssssssssss");
        vbox.getChildren().add(label);
        label.setId("label");

        primaryStage.setScene(sc);
        primaryStage.setTitle("css demo");
        primaryStage.show();
    }
}
