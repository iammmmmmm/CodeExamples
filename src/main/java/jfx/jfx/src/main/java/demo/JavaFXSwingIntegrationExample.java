package demo;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class JavaFXSwingIntegrationExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        final SwingNode swingNode = new SwingNode();
        createAndSetSwingContent(swingNode);

        StackPane pane = new StackPane();
        pane.getChildren().add(swingNode);

        stage.setTitle("JavaFX / Swing Integration");
        stage.setScene(new Scene(pane, 300, 200));
        stage.show();
    }

    private void createAndSetSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTextField swingTextField = new JTextField("Swing Text Field");
                swingNode.setContent(swingTextField);
                swingTextField.setBorder(BorderFactory.createCompoundBorder(
                        swingTextField.getBorder(),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            }
        });
    }
}
