package demo;

/*
 * @author Iammm
 * @Time 2024/1/6 16:23
 */

import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Event extends Application {

    int a = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button button = new Button("Click me");
        // 注册事件过滤器
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println((++a) + "Mouse clicked event filtered at button");
        });
        // 注册事件处理器
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println((++a) + "Mouse clicked event handled at button");
            System.out.println(event.isConsumed());
            System.out.println(event.getSource());
            System.out.println(event.getEventType());
            System.out.println(event.getTarget());
        });
        // button.setOnAction(event -> {
        //     System.out.println((++a) + "button event handler");
        // });
        StackPane root = new StackPane(button);
        StackPane root1 = new StackPane(root);
        StackPane root2 = new StackPane(root1);
        StackPane root3 = new StackPane(root2);
        StackPane root4 = new StackPane(root3);
        root1.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> System.out.println(a++ + "Mouse clicked event filtered at root1"));
        root1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println(a++ + "Mouse clicked event handled at root1"));
        root2.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> System.out.println(a++ + "Mouse clicked event filtered at root2"));
        root2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println(a++ + "Mouse clicked event handled at root2"));
        root3.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> System.out.println(a++ + "Mouse clicked event filtered at root3"));
        root3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println(a++ + "Mouse clicked event handled at root3"));
        root4.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> System.out.println(a++ + "Mouse clicked event filtered at root4"));
        root4.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println(a++ + "Mouse clicked event handled at root4"));
        primaryStage.setTitle("Event handling example");
        Scene scene = new Scene(root4, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

