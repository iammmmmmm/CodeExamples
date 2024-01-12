package demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * @author Iammm
 * @Time 2024/1/10 18:15
 */
public class textFied extends Application {

    static {
        System.setProperty("com.sun.javafx.isEmbedded", "true");
        System.setProperty("com. sun.javafx.virtualKeyboard", "native");
        System.setProperty("javafx.touch", "true");
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        TextArea textArea = new TextArea();


        root.getChildren().add(textArea);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
