package demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * 更多更多的按钮
 *
 * @author Iammm
 * @Time 2023/12/14 16:25
 */
public class moreMoreBUtton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("更多更多的按钮");
        var group = new Group();
        FlowPane flowPane=new FlowPane(group);
        Scene scene = new Scene(flowPane);
        moreMOremore(scene,15,flowPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moreMOremore(Scene scene, int i, FlowPane flowPane) {
        for (int i1 = 0; i1 < i; i1++) {
            var b=new Button("按钮"+i1);
            b.autosize();
            b.setOnAction(event -> System.out.println("点击了"+b.getText()));
flowPane.getChildren().add(b);
        }
    }
}
