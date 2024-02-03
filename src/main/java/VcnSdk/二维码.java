package VcnSdk;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.EnumMap;

/**
 *  在指定路径生成一张二维码，内容类型为字符串，可以是普通文本或者是超链接
 *
 *  生成二维码的步骤
 *      1.根据Zxingjar包生成二维码，这只是生成二维码，并不是生成二维码图片
 *      2.创建一张图片，大小和二维码的大小一致。
 *      3.二维码可以看成是二维数组，所以遍历二维码，然后把二维码的每一个点添加到图片上，添加的时候，判断是黑色点，还是白色点。
 *          encode.get(i,j)?BLACK:WHITE
 *      4.最后把真正的二维码图片生成到指定路径即可。
 */
public class 二维码 {

    //0x：代表是16进制，ff：代表完全不透明度，其余6位代表颜色值（000000：代表黑色）
    //定义二维码的颜色
    private static final int BLACK = 0xff000000;
    //定义二维码的背景颜色
    private static final int WHITE = 0xffffffff;

    //二维码格式参数集合
    private static final EnumMap<EncodeHintType,Object> hints =
            new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
    private static final EnumMap<DecodeHintType,Object> hintsD = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);

    //静态代码块初始化参数，在类加载的时候就初始化，而且在类的生命周期内只初始化一次
    static {
        /*
         *  二维码的纠错级别(排错率),4个级别： L(7%)、M(15%)、Q (25%)、H(30%)
         *  最高级别为:H
         *  纠错信息同样存储在二维码中，纠错级别越高，纠错信息占用的空间越多，那么能存储的有用信息就越少；
         */
        hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);
        // 二维码边界空白大小：1，2，3，4(4为默认，最大)
        hints.put(EncodeHintType.MARGIN,1);
        //设置二维码存储内容的字符集
        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        hintsD.put(DecodeHintType.CHARACTER_SET,"UTF-8");
    }

    private static void createZXingCodeSaveToDisk(String content,int width,int height,String savePath,String imageType){
        try {
            BitMatrix encode = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            //获得二维码的宽高
            int codeWidth = encode.getWidth();
            int codeHeight = encode.getHeight();
            //创建图片
            BufferedImage image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);
            //把二维码里面的信息写到图片里面
            for (int i = 0; i < codeWidth; i++) {
                for (int j = 0; j < codeHeight; j++) {
                    image.setRGB(i,j,encode.get(i,j)?BLACK:WHITE);
                }
            }
            //保存图片到指定位置
            File file = new File(savePath);
            if(!file.exists()){
                //文件不存在则创建
                file.createNewFile();
            }
            ImageIO.write(image,imageType,file);
            //打印一句话，给个提示是否成功
            System.out.println("二维码生成成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String decodeQRCodeForPath(String path){
        //该文件对象映射二维码图片
        File file = new File(path);
        if(file.exists()){
            try {
                return decodeQRCodeStreamForStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     *  解析二维码
     * @param ins 读取二维码图片的流
     * @return 二维码中的文本内容
     */
    private static String decodeQRCodeStreamForStream(InputStream ins) {
        if(ins != null){
            try {
                //将读取二维码图片的流转为图片对象
                BufferedImage image = ImageIO.read(ins);
                BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
                HybridBinarizer binarizer = new HybridBinarizer(source);
                BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
                MultiFormatReader reader = new MultiFormatReader();
                Result result = reader.decode(binaryBitmap,hintsD);
                //返回二维码中的文本内容
                String content = result.getText();
                System.out.println("二维码解析成功");
                return content;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
    public static void  生成二维码到硬盘(String 文本,int 宽,int 高,String 保存路径,String 文件类型){
        createZXingCodeSaveToDisk(文本, 宽, 高, 保存路径, 文件类型);
    }
    public static String 从硬盘解析二维码(String 文件路径){
        return decodeQRCodeForPath(文件路径);
    }


    public static void main(String[] args) {
        createZXingCodeSaveToDisk("TAA",300,300,"D://TAA.jpg","JPEG");
        createZXingCodeSaveToDisk("TESTA",300,300,"D://TESTA.jpg","JPEG");
        String myName = decodeQRCodeForPath("d:/TAA.jpg");
        System.out.println(myName);
        String myBlog = decodeQRCodeForPath("d:/TESTA.jpg");
        System.out.println(myBlog);
    }
}

