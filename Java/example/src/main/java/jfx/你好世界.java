package jfx;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;

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

        //设置为全屏
        primaryStage.setFullScreen(true);
        //设置标题
        primaryStage.setTitle("AABB");
        //设置样式
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        //显示窗口
        primaryStage.show();
        //创建VBox
        VBox vBox=new  VBox();
        //创建场景
        Scene scene=new Scene(vBox);
        //设置场景
        primaryStage.setScene(scene);
        //设置颜色
        Color color=new Color(1,0.5,0.2,0.4);
        //设置填充颜色
        scene.setFill(color);
        //设置宽度
        primaryStage.setWidth(Screen.getPrimary().getBounds().getWidth());

    }
}
