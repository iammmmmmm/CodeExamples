package demo.rxControl;

import demo.demo01;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * a
 *
 * @author Iammm
 * @Time 2024/1/25 14:02
 */
public class demo_Button extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(demo01.class.getResource("demo_Button.fxml"));
        stage.setTitle("Hello!");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }
}
