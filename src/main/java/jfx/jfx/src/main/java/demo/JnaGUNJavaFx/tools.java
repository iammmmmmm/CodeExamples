package demo.JnaGUNJavaFx;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;

/**
 * jna tools
 *
 * @author Iammm
 * @Time 2024/1/7 17:57
 */
public class tools {

    public interface User32 extends StdCallLibrary {
        /**
         *
         * 定义任何方法时都要在微软的api文档中查询是否有改方法，以及方法名现在是什么
         *
         * */
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
        boolean MoveWindow(HWND hWnd, int X, int Y, int nWidth, int nHeight, boolean bRepaint);
        HWND FindWindowA(String lpClassName, String lpWindowName);
        boolean SetWindowTitleA(HWND hWnd, String sTitle);
    }

    public static void ChangeSizeByTitle(String title,int  x,int y,int width,int height) {
        //get the win32 window Object
        HWND hWnd = User32.INSTANCE.FindWindowA(null, title);
        if (hWnd == null) {
            System.err.println("Window not found");
        } else {
            User32.INSTANCE.MoveWindow(hWnd, x, y, width, height, true);
        }
    }
}
