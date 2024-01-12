package demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.stage.Stage;

/**
 * @author Iammm
 * @Time 2023/12/26 19:18
 */
public class demoXform extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Box box=new Box(10,10,10);
        box.setTranslateX(100);
        box.setTranslateY(100);
        Group group=new Group(box);
        Scene scene=new Scene(group);
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case UP -> box.setRotate(box.getRotate()+1);
                case DOWN -> box.setRotate(box.getRotate()-1);
                case LEFT -> box.setScaleX(box.getScaleX()-1);
                case RIGHT -> box.setScaleX(box.getScaleX()+1);
                case SPACE -> box.setDrawMode(DrawMode.LINE);
                case ALT ->  box.setDrawMode(DrawMode.FILL);
                default -> System.out.println(event.getCode());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
