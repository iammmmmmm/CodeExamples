package demo;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

/**
 * javafx异步处理
 *
 * @author Iammm
 * &#064;Time  2024/1/25 10:51
 */
public class taskKKKs extends Application {
    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TAskkks");
        var root = new Group();
        var button = new Button("click me");
        button.setLayoutY(40);
        ProgressBar bar = new ProgressBar();

        bar.setPrefSize(200, 30);


        var task = new dowTask();
        bar.progressProperty().bind(task.progressProperty());
        button.setOnAction(e -> {
            System.out.println("clicked");
            new Thread(task).start();

        });

        var button1 = new Button("cancel");
        button1.setLayoutY(90);
        button1.setOnAction(e -> task.cancel());



        root.getChildren().add(button1);
        root.getChildren().add(bar);
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

}

class dowTask extends Task<Void> {

    /**
     * Invoked when the Task is executed, the call method must be overridden and
     * implemented by subclasses. The call method actually performs the
     * background thread logic. Only the updateProgress, updateMessage, updateValue and
     * updateTitle methods of Task may be called from code within this method.
     * Any other interaction with the Task from the background thread will result
     * in runtime exceptions.
     *
     * @return The result of the background work, if any.
     * @throws Exception an unhandled exception which occurred during the
     *                   background operation
     */
    @Override
    protected Void call() throws Exception {
        for (int i = 0; i < 100; i++) {
            if (!isCancelled()) {
                updateProgress(i, 100);
                updateMessage("Downloading file: " + i + "%");
                Thread.sleep(100);
            } else break;
        }
        return null;
    }

    /**
     * @param mayInterruptIfRunning {@code true} if the thread
     *                              executing this task should be interrupted (if the thread is
     *                              known to the implementation); otherwise, in-progress tasks are
     *                              allowed to complete
     */
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        System.out.println("cancel called");
        return super.cancel(mayInterruptIfRunning);
    }
}