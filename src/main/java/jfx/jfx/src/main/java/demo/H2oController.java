package demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.PerspectiveCamera;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Iammm
 * @Time 2023/12/26 18:03
 */
public class H2oController implements Initializable {
    int z = 0, x = 0, y = 0;
    @FXML // fx:id="Camera"
    private PerspectiveCamera Camera; // Value injected by FXMLLoader
    @FXML // fx:id="hBall"
    private Sphere hBall; // Value injected by FXMLLoader
    @FXML // fx:id="key1"
    private Cylinder key1; // Value injected by FXMLLoader
    @FXML // fx:id="key2"
    private Cylinder key2; // Value injected by FXMLLoader
    @FXML // fx:id="oball1"
    private Sphere oball1; // Value injected by FXMLLoader
    @FXML // fx:id="oball2"
    private Sphere oball2; // Value injected by FXMLLoader

    @FXML
    void CameraKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP -> Camera.setTranslateZ(++z);
            case DOWN -> Camera.setTranslateZ(--z);
            case LEFT -> Camera.setTranslateX(++x);
            case RIGHT -> Camera.setTranslateX(--x);
            default -> System.out.println(event.getCode());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       Camera.fieldOfViewProperty();
    }
}
