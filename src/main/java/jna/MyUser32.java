package jna;

import com.sun.jna.*;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;

import java.util.Arrays;
import java.util.List;

/**
 * @author Iammm
 * @Time 2024/2/4 10:39
 */
public interface MyUser32 extends Library {
    MyUser32 INSTANCE = Native.load("MyUser32", MyUser32.class);

    /**
     * 查找 Windowa
     *
     * @param lpClassName  LP 类名, 可以为 null
     * @param lpWindowName LP 窗口名称
     * @return {@link WinDef.HWND}
     */
    WinDef.HWND FindWindowA(String lpClassName, String lpWindowName);

    /**
     * 获取窗口线程进程 ID
     *
     * @param hWnd          H Wnd（英语：H Wnd）
     * @param lpdwProcessId LPDW 进程 ID 将会写入到此变量
     * @return {@link WinDef.DWORD}
     */
    WinDef.DWORD GetWindowThreadProcessId(WinDef.HWND hWnd, WinDef.DWORDByReference lpdwProcessId);

    /**
     * 打开进程
     * <a href="https://learn.microsoft.com/en-us/windows/win32/api/processthreadsapi/nf-processthreadsapi-openprocess">microSoft api doc</a>
     * 使用完句柄后，请务必使用 CloseHandle 函数将其关闭。
     *
     * @param dwDesiredAccess DW 所需访问权限
     * @param bInheritHandle  b 如果此值为 TRUE，则此进程创建的进程将继承句柄。否则，进程不会继承此句柄。
     * @param dwProcessId     DW 要打开的本地进程的标识符。
     * @return {@link WinNT.HANDLE}
     */
    WinNT.HANDLE OpenProcess(int dwDesiredAccess, boolean bInheritHandle, WinDef.DWORD dwProcessId);

    /**
     * 获取进程 IDBY 窗口名称
     * <a href="https://learn.microsoft.com/en-us/windows/win32/api/handleapi/nf-handleapi-closehandle">microSoft api doc</a>
     * 此函数将关闭指定的句柄。
     *
     * @param WindowName 窗口名称
     * @return {@link WinNT.HANDLE}
     */
    // WinDef.BOOL CloseHandle(WinNT.HANDLE hObject);

    WinNT.HANDLE getProcessIDByWindowName(WString WindowName);

    class KeyValuePair extends Structure {
        public static class ByReference extends KeyValuePair implements Structure.ByReference {}

        public int key;
        public WString value;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("key", "value");
        }
    }
    Pointer GetProcessList(IntByReference length);

    WTypes.BSTR ReturnStringList(int length);

}






