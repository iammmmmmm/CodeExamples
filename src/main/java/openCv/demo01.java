package openCv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * opencv测试
 * @author Iammm
 * @Time 2023/12/15 11:31
 */
public class demo01 {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat mat=new Mat(3,3, CvType.CV_8U);
        System.out.println(mat.dump());;
    }
}
