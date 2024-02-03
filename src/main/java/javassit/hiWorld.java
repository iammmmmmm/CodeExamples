package javassit;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;

/**
 * @author Iammm
 * @Time 2024/1/24 20:17
 */
public class hiWorld {
    public static void main(String[] args) throws NotFoundException, IOException, CannotCompileException {
        new hiWorld().make_class();
    }

    void make_class() throws NotFoundException, IOException, CannotCompileException {
        ClassPool classPool = ClassPool.getDefault(); // 获取管理类的类池，可用于创建，获取某个类
        CtClass ctClass = classPool.makeClass("javassit.MyClass");
        ctClass.writeFile();  // 创建该类
    }

}

