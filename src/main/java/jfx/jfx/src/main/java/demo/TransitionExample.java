package demo;

/**
 * @author Iammm
 * @Time 2023/12/20 11:39
 */
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TransitionExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建一个矩形
        Rectangle rectangle = new Rectangle(50, 50, 100, 100);
        rectangle.setFill(Color.BLUE);

        // 创建关键帧，定义矩形的颜色和大小过渡效果
        KeyFrame colorFrame = new KeyFrame(Duration.seconds(2),
                new KeyValue(rectangle.fillProperty(), Color.RED),
                new KeyValue(rectangle.widthProperty(), 200),
                new KeyValue(rectangle.heightProperty(), 200)
        );

        // 创建Timeline并将关键帧添加到时间线中
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(colorFrame);
        timeline.setCycleCount(Timeline.INDEFINITE); // 设置动画循环次数

        // 创建过渡效果，使矩形平滑过渡到新属性值
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), rectangle);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.5);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setCycleCount(FadeTransition.INDEFINITE);

        // 创建ParallelTransition并将时间线动画和过渡效果组合在一起
        ParallelTransition parallelTransition = new ParallelTransition(rectangle, timeline, fadeTransition);
        parallelTransition.play();

        StackPane root = new StackPane(rectangle);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}