package demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * demo01的控制类
 *
 * @author Iammm
 * @Time 2023/12/7 14:30
 */
public class demo01Controller extends demo01 {

    @FXML
    public CheckBox checkBox;
    @FXML
    public ColorPicker colorPicker;
    @FXML
    public DatePicker datePicker;
    @FXML
    public Label label1;
    @FXML
    public AnchorPane anchorpane1;
    String str = "你还点击我！";
    String str1 = "你点击了我！";
    int a = 1;
    double b = 1;
    @FXML
    private Button button1;
    @FXML
    private AnchorPane pane1;
    public demo01Controller() {
        System.out.println("demo01Controller");

    }

    public void button1Clicked() throws IOException {

        if (a < 2) {
            if (button1.getText().equals(str1)) {
                button1.setText(str);
                button1.autosize();
                // 如果文本过长会变成1023 ***
            } else {
                button1.setText(str1);
            }
        } else {
            switch (a) {
                case 3 -> button1.setText("ヾ(•ω•`)o");
                case 4, 5 -> button1.setText("(◍•ᴗ•◍)");
                case 6 -> button1.setText("╰(*°▽°*)╯");
                case 7 -> button1.setText("Owo");
                case 8 -> button1.setText("(｡･ω･｡)");
                case 9 -> button1.setText("Stop!");
                case 10 -> button1.setShape(new Circle(100));
                case 11 -> button1.setShape(new Rectangle(100, 100));
                case 12 -> button1.setEffect(new DropShadow(10, Color.BLACK));
                case 13, 14, 15, 16, 17, 18 -> button1.setEffect(new Glow(b += 0.001));
                case 19 -> button1.setEffect(null);

                default -> button1.setText("‼o(≧口≦)o ️");
            }
        }

        label1.setText("你点击了按钮" + (a++) + "次");
    }

    public void checkBoxClicked() {
        checkBox.setText(str1);

    }

    public void checkBoxRequested(@NotNull ContextMenuEvent contextMenuEvent) {
        checkBox.setText(contextMenuEvent.toString());
    }

    public void colorPickerRequested(ContextMenuEvent contextMenuEvent) {
        colorPicker.setTooltip(new Tooltip(
                str1
        ));
        label1.setText("you clicked colorPicker");
    }

    public void textChanged(@NotNull InputMethodEvent inputMethodEvent) {
        label1.setText(label1.getText() + "\n" + inputMethodEvent);
    }
}
