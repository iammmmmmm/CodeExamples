package jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author Iammm
 * @date 2023/10/25 12:36
 * @description jna demo
 */
public interface JnaLibrary extends Library {
    // JNA 为 dll 名称
    JnaLibrary INSTANCE = Native.load("libjnaDemo01", JnaLibrary.class);

    int aab();

}

class test1 {
    public static void main(String[] args) {
        System.out.println(JnaLibrary.INSTANCE.aab());
    }
}
