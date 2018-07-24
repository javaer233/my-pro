package errorAndException;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.ALL;

/**
 * @Author kai
 * @Description 日志输出，使用java.util下的logger
 * @Create 2018-05-11 9:02
 **/
public class LoggerTest {
    @Test
    public void test1(){
        Logger logger = Logger.getLogger("com.fy.myLogger");
        logger.setLevel(Level.ALL);//设置记录的日志级别
        logger.info("info:yeah");
        logger.warning("warning:no");
        logger.severe("severe:not");
        logger.config("config:cc");
        logger.fine("fine:i'm fine");
        logger.finer("finer:finer than that");
        logger.finest("finest:");
//        默认情况下，只会在控制台打印info,warning,severe级别的日志，显示其他的需要对控制台输出级别进行配置
    }
}
