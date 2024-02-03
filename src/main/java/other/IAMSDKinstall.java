package other;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Iammm
 * @Time 2024/1/12 13:09
 */
public class IAMSDKinstall {
    private static String sdkPath;
   private static String installInfoPath;
   private static String installedMask="<category name=\"IAM定制组件库\" comement=\"IAM定制组件库\">";
    private static BufferedReader SdkbufferedReader;
private static BufferedReader installInfoBufferedReader;
    public static void main(String[] args) {
        install(args);
    }

    private static void install(String[] args) {
        sdkPath = args[0];
        installInfoPath = args[1];
        try {
            SdkbufferedReader=new BufferedReader(new FileReader(sdkPath));
            installInfoBufferedReader=new BufferedReader(new FileReader(installInfoPath));

        } catch (FileNotFoundException e) {
            System.err.println("无法读写文件！请确保安装程序具有文件读写权限。");
            throw new RuntimeException(e);
        }
    }
}
