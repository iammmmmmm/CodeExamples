package jme;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.util.BufferUtils;

/**
 * 网格
 *
 * @author yanmaoyuan
 *
 */
public class HelloMesh extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        // 六个顶点
        float[] vertex = {
                2.5f, 4f, 0f, // 零
                1f, 3.26f, 0f, // 壹
                1f, 1.74f, 0f, // 贰
                2.5f, 1f, 0f, // 叁
                4f, 1.74f, 0f, // 肆
                4f, 3.26f, 0f// 伍
        };

        // 四个三角形
        int[] indices = new int[] {
                0, 1, 2, // 三角形0
                2, 3, 4, // 三角形1
                4, 5, 0, // 三角形2
                0, 2, 4 // 三角形3
        };

        // 创建网格
        Mesh mesh = new Mesh();
        // 保存顶点位置和顶点索引
        mesh.setBuffer(Type.Position, 3, BufferUtils.createFloatBuffer(vertex));
        mesh.setBuffer(Type.Index, 1, BufferUtils.createIntBuffer(indices));

        mesh.updateBound();// 更新边界
        mesh.setStatic();// 设为静态模型

        // 创建材质，使我们可以看见这个六边形
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //mat.getAdditionalRenderState().setWireframe(true);

        // 使用网格和材质创建一个物体
        Geometry geom = new Geometry("六边形");
        geom.setMesh(mesh);
        geom.setMaterial(mat);

        // 将物体添加到场景图中
        rootNode.attachChild(geom);

    }

    public static void main(String[] args) {
        // 启动程序
        HelloMesh_XY app = new HelloMesh_XY();
        app.start();
    }
}
