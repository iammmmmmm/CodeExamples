package demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

 /**
 * All in one !!!
 *
 * @author Iammm
 * @Time 2023/12/7 14:27
 */
public class demo01 extends Application {
    public Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(demo01.class.getResource("All_in_one_button.fxml"));
        stage.setTitle("Hello!");
        stage.setScene(fxmlLoader.load());
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
