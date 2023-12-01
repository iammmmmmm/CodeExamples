package base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

/**
 * 演示01
 * 读取图片并将其转换成base64
 *
 * @author Iammm
 * @Time 2023/12/1 11:32
 * @date 2023/12/01
 */
public class demo01  {
    //以下方法是错误的，转出来的base64不正确
    // public static void main(String[] args){
    //     File image=new File("src/main/resources/wallhaven-6dykgx.png");
    //     InputStream inputStream=null;
    //     byte[] bytes=null;
    //     try{
    //         inputStream=new FileInputStream(image);
    //         bytes=new byte[inputStream.available()];
    //         inputStream.read(bytes);
    //         inputStream.close();
    //         String base64encodedString = Base64.getUrlEncoder().encodeToString(bytes);
    //         System.out.println(base64encodedString);
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    //
    // }

    /**
     * 对方法进行测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
            String base64String = imageToBase64("src/main/resources/wallhaven-6dykgx.png");
            System.out.println(base64String);
        }

    /**
     * 图像转 base64
     *
     * @param imagePath 图像路径
     * @return {@link String}
     */
    public static String imageToBase64(String imagePath) {
String base = null;
            File file = new File(imagePath);
            try (FileInputStream imageInFile = new FileInputStream(file)) {
                // 读取图片文件并转为字节数组
                byte[] imageData = new byte[(int) file.length()];
                imageInFile.read(imageData);
                // 对字节数组进行Base64编码
            base= Base64.getEncoder().encodeToString(imageData);
            if (base.length()%4!=0){
                System.out.println("no 4!!!!");
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return base;
        }


}
