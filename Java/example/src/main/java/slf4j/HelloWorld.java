package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*@author Iammm
*@date 2023/10/21 18:23
*/
public class HelloWorld {
    private final Logger logger = LoggerFactory.getLogger(HelloWorld.class);


    public static void main(String[] args) {
        new HelloWorld().logTest();
    }

    private void logTest() {
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
        logger.warn("warn");
        logger.trace("trace");
        //通配符{}(？应改叫这个🤔)
        logger.info("{}", "info");
    }
}
