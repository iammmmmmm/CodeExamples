package demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import java.security.Key;

/**
 * 3d demo
 *
 * @author Iammm
 * @Time 2023/12/26 15:15
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.CullFace;
import javafx.stage.Stage;
import javafx.scene.shape.Sphere;
public class SphereCullFace extends Application {
    @Override
    public void start(Stage stage) {
        //Drawing Sphere1
        Sphere sphere1 = new Sphere();
        //Setting the radius of the Sphere
        sphere1.setRadius(50.0);
        //Setting the position of the sphere
        sphere1.setTranslateX(100);
        sphere1.setTranslateY(150);
        //setting the cull face of the sphere to front
        sphere1.setCullFace(CullFace.FRONT);
        //Drawing Sphere2
        Sphere sphere2 = new Sphere();
        //Setting the radius of the Sphere
        sphere2.setRadius(50.0);
        //Setting the position of the sphere
        sphere2.setTranslateX(300);
        sphere2.setTranslateY(150);
        //Setting the cull face of the sphere to back
        sphere2.setCullFace(CullFace.BACK);
        //Drawing Sphere3
        Sphere sphere3 = new Sphere();
        //Setting the radius of the Sphere
        sphere3.setRadius(50.0);
        //Setting the position of the sphere
        sphere3.setTranslateX(500);
        sphere3.setTranslateY(150);
        //Setting the cull face of the sphere to none
        sphere2.setCullFace(CullFace.NONE);
        //Creating a Group object
        Group root = new Group(sphere1, sphere2, sphere3);
        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);
        //Setting title to the Stage
        stage.setTitle("Drawing a Sphere");
        //Adding scene to the stage
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}