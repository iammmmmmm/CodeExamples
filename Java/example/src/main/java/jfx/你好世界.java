package jfx;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import java.util.Scanner;

/**
 * @author Iammm
 * @date 2023/10/24 17:25
 * @description jfx你好世界！
 */
public class 你好世界 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage = new Stage();

        primaryStage.setFullScreen(true);
        primaryStage.setTitle("AABB");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        VBox vBox=new  VBox();
        Scene scene=new Scene(vBox);
        primaryStage.setScene(scene);
        Color color=new Color(1,0.5,0.2,0.4);
        scene.setFill(color);
        primaryStage.setWidth(Screen.getPrimary().getBounds().getWidth());

    }
}
