package demo.JnaGUNJavaFx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * jna gan javafx
 *
 * @author Iammm
 * @Time 2024/1/7 17:57
 */
public class demo extends Application {
    public static void main(String[] args) {
        // launch(args);
        new demo().a();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String title = "JNA GAN JAVAFX";
        primaryStage.setTitle(title);
        var scene=new Scene(new Group(), 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        Platform.runLater(() ->{
            System.out.println("AAAAAAAAAA");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tools.ChangeSizeByTitle(title,
                    500,
                    500,
                    10,
                    10);
        });

    }


    void a(){

       var b= Integer.parseInt("1.0e+666");
        System.out.println(b);
    }
}
