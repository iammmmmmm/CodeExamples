package VcnSdk;
/* 引用桌面端核心支持库 */
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.paint.Paint;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
/*
 ** 封装可视组件时需注意：所有可视组件都必须继承自视图类、
 ** 视图类作为基础组件已经实现了部分事件和可视化组件的功能；
 ** 在封装时需注意回调事件的处理。
 ** 本模板默认演示封装一个蓝色按钮作为案例。
 */
public class 圆形按钮
{
    public Button mButton;

    /*
     ** 核心控件的创建方法；在该方法中实现原生组件的实例化和初始化。
     */
    // @Override
    public Control createView()
    {
        mButton = new Button();
        //

        return mButton;
    }

    /* 两个相同的方法名称、且符合单参数、单返回值；则默认表示为属性 */
    public void 标题(String text)
    {
        mButton.setText(text);
    }

    public String 标题()
    {
        return mButton.getText();
    }


    /*
     ** 设置当用户点击按钮时的回调事件；这里需要注意：事件名称与接口名称、以及注册事件回调接口
     ** 的方法名称的格式必须保持一致。
     ** 例如：这里的事件为“被单击”
     ** 那么接口名称应该为：被单击回调
     ** 注册回调事件的方法名称必须为：置被单击回调
     ** 提示：事件回调接口的代码可以通过类库封装插件中工具栏里面快捷生成工具生成
     */

}
