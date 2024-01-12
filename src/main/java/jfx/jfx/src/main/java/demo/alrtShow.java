package demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * alrtSHow
 *
 * @author Iammm
 * @Time 2023/12/29 15:38
 */
public class alrtShow extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);

        Button b = new Button("Sss");
        root.getChildren().add(b
        );
        b.setOnAction(e -> {
            var a = new Alert(Alert.AlertType.ERROR);
            a.show();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
        Platform.runLater(()->{
            var a = new Alert(Alert.AlertType.INFORMATION);
            a.show();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
