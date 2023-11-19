package jni;

/**
 * Hello World
 *
 * @author Iammm
 * @date 2023/10/24 13:47
 */

/**
 * jni编写流程：
 * 1.在类中声明一个本地方法eg：public static native void sayHello();
 * 2.编写对应的c/cpp库 例如 jni/c/libHelloJni.c
 * 3.编译生成dll文件 eg：libHelloJni.dll
 * 4.在java代码中加载dll eg：System.loadLibrary("libHelloJni.dll");
 * 5.调用本地方法
 * */
public class HelloJni {
    public static native void sayHello();
}

class Test {
    static {
        /**
         * 注意
         * ‼️‼️‼️‼️‼️‼️‼️‼️‼️
         * ‼️‼️‼️‼️‼️‼️‼️‼️‼️
         * 一定要在虚拟机选项上加上你dll的存放路径，例如本项目
         * -Djava.library.path="src/main/java/jni/c/"
         * ‼️‼️‼️‼️‼️‼️‼️‼️‼️
         * ‼️‼️‼️‼️‼️‼️‼️‼️‼️
         * jni可以非常有效的治疗低血压🙃🙃🙃
         */
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("libHelloJni");
    }

    public static void main(String[] args) {
        HelloJni.sayHello();
    }
}
