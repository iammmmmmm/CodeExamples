package Thread;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *
 * @author Iammm
 * @Time 2023/12/16 13:54
 */
public class YuJie {
    public static void main(String[] args) {
        JK();
    }

    private static void JK() {
        var JK1 = new Thread(() -> {
            int time = 0;
            while (true) System.out.print("time:" + (time++) + "\r");
        });
        JK1.start();
    }
}
