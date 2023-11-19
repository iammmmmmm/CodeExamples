package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * slf4j的 世界您好
 *
 * @author Iammm
 * @date 2023/10/21 18:23
 */
public class HelloWorld {
    /**
     * 日志
     */
    private final Logger logger = LoggerFactory.getLogger(HelloWorld.class);


    /**
     * 主要
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        new HelloWorld().logTest();
    }

    /**
     * 日志测试
     */
    private void logTest() {
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
        logger.warn("warn");
        logger.trace("trace");
        // 通配符{}(？应该叫这个🤔)
        logger.info("{}", "info");
    }
}
