package VcnSdk.数据加密;

/* 引入桌面开发框架的核心类 */

/* 不可视组件与原生Java类库编写的格式完全相同；可直接拷贝已有源码进行封装。 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class 数据加密
{
    public static String 计算MD5(String str)
    {
        String hexStr = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(str.getBytes("utf-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            hexStr = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hexStr;
    }

}
