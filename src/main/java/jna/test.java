package jna;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.ptr.IntByReference;

/**
 * @author Iammm
 * @Time 2024/2/4 12:37
 */
public class test {
    public static void main(String[] args) {
        MyUser32 myUser32 = MyUser32.INSTANCE;
       //  IntByReference length=new IntByReference();
       //  Pointer result= myUser32.GetProcessList(length);
       //  for (int i = 0; i < length.getValue(); i++) {
       //      MyUser32.KeyValuePair
       //              pair = new MyUser32.KeyValuePair();
       //      pair.read();
       //      System.out.println("Name:"+pair.value+"\nPID:"+pair.key);
       //  }
       // var a= myUser32.ReturnStringList(1);
myUser32.getProcessIDByWindowName(new WString("notepad.exe"))        ;
    }
}
