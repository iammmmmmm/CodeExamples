package Thread;

import org.apache.poi.ss.formula.functions.T;

import java.util.function.Consumer;

/**
 * about      ::
 *
 * @author Iammm
 * @Time 2024/1/3 13:16
 */
public class demo {
    private static void main1() {
        while (true) System.out.println("hello");
    }

    private static void main1(String a) {
        while (true) System.out.println("hello@2XSWSW");
    }

    public static void main(String[] args) {
        Runnable r = demo::main1;
        Consumer<String> r2 = demo::main1;
        Runnable r3=()->{
          while (true) System.out.println("r3");
        };
        new Thread(r3).start();
        // new Thread(r).start();
        new Thread(()->r2.accept("A")).start();
        new Thread(demo::main1).start();

    }
}
