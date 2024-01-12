package demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * webViewDemo01
 *
 * @author Iammm
 * @Time 2023/12/16 16:56
 */
public class webViewDemo01 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene=new Scene(new Group(),600,600);
        var w=new WebView();
        w.getEngine().load("https://www.qionggedy.cc/");
        scene.setRoot(w);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
