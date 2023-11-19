package json.Gson;

import com.google.gson.Gson;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

/** gson first demo
 * @author Iammm
 * @date 2023/11/13 18:10
 *
 */
public class demo01 {
    static Logger logger = org.slf4j.LoggerFactory.getLogger(demo01.class);

    public static void main(String[] args) {
        Gson gson = new Gson();
        int[] i = {1, 2, 3};
        String s = gson.toJson(i);
        logger.info("i{}", s);
        Map<String, String> stringMap = new HashMap<String, String>();
        for (int i1 = 0; i1 < 10; i1++) {
            stringMap.put("key" + i1, "value" + i1);
        }
        stringMap.put("hello", "world");
        String s2 = gson.toJson(stringMap);
        logger.info("s2{}", s2);
        /*这里一般写
         Map<String, String> stringMap1 = gson.fromJson(s2, Map.class);
          但是idea对此有意见╮(╯▽╰)╭所以我在这里用  var 关键字
         */
        var stringMap2 = gson.fromJson(s2, Map.class);
        logger.info("stringMap2{}", stringMap2.toString());
        boolean isHello = stringMap2.containsKey("hello");
        logger.info("is have the kay named Hello: {}", isHello);
        logger.info("is have the value world: {}", stringMap2.containsValue("world"));
        logger.info("is hava the key \"aab\" :{} ", stringMap2.containsKey("aab"));
/*
var 只有三个字母真好使(/▽＼)
 */
        var ttt=new testtttttttttt();
        logger.info(gson.toJson(ttt));
    }
}
class testtttttttttt{
    /*
     * 这里用t1,t2,t3是 Gson对类的序列化，的简单使用
     */
    private String t1="t333338u34rtyusgviuhshdkljvbkjdcgvksbcig";
    private int t2=123456789;
    private  Map<String,String> t3=new HashMap<>();
    public testtttttttttt() {
        for (int i = 0; i < 10; i++) {
            t3.put("key"+i,"value"+i);
        }
    }
}