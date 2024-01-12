package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 网格pane
 *
 * @author Iammm
 * @Time 2023/12/20 12:16
 */
public class GirPane extends Application {
    public static void main(String[] args) {
    launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GirPane");
        GridPane gridPane=new GridPane();
        for (int i = 0; i < 100; i++) {
            var b=new Button("按钮"+i);
            gridPane.add(b,i%10,i/10);
        }
        primaryStage.setScene(new Scene(gridPane, 300, 200));
        primaryStage.show();
    }
}
