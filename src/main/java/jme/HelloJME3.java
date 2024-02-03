package jme;

/**
 * @author Iammm
 * @Time 2024/2/2 18:42
 */

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class HelloJME3 extends SimpleApplication {

    private Material mat;  // 创建材质
    private Geometry geom;  // 创建几何体

    public static void main(String[] args) throws IOException {
        HelloJME3 app = new HelloJME3();
        app.setShowSettings(false);
        app.setSettings(app.newSettings(true));
        app.start();
        System.out.println("1");

    }

    private AppSettings newSettings(boolean b) throws IOException {


        var settings = new AppSettings(b);
        settings.setWidth(2048);
        settings.setHeight(1080);
        settings.setTitle("HelloJME");
        // load icon
        var iconImage16 = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("idea16.png")));
        var iconImage32 = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("idea32.png")));
        var iconImage128 = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("idea128.png")));

        // set icon
        settings.setIcons(new BufferedImage[]{iconImage16,iconImage32,iconImage128}); // 设置应用程序图标

        return settings;
    }

    @Override
    public void simpleInitApp() {
        Box b = new Box(1, 1, 1); // 创建一个立方体
        geom = new Geometry("Box", b);
        mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.White);   // 设置材质为蓝色
        geom.setMaterial(mat);                   // 将材质应用到几何体上
        rootNode.attachChild(geom);              // 将几何体添加到场景图中
        // new a light
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-1, -2, -3));
        rootNode.addLight(sun);
    }


}
