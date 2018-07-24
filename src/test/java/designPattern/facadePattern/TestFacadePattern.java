package designPattern.facadePattern;

import designPattern.bean.Entertainment;
import designPattern.bean.GameNews;
import designPattern.bean.Sports;
import org.junit.Test;

/**
 * @Author kai
 * @Description 测试类
 * @Create 2018-04-27 16:04
 **/
public class TestFacadePattern {
    /**
     * @Title: testWithoutFacade
     * @Description: 没有使用外观类时，需要手动调用每一个类，程序之间的耦合性差
     * @author kai
     * @date 2018/4/27 16:37
     * @param []
     * @return void
     */
    @Test
    public void testWithoutFacade(){
        Sports sports = new Sports();
        GameNews gameNews = new GameNews();
        Entertainment entertainment = new Entertainment();

        sports.read();
        gameNews.read();
        entertainment.read();

        sports.close();
        gameNews.close();
        entertainment.close();
    }

    /**
     * @Title: testWithFacade
     * @Description: 使用外观类时，调用者于被包装类解耦，且调用外观类方法以引用被包装字类的方法，调用简单了，
     * 但对程序的控制不够灵活，需要更改调用顺序时，需要重新设计外观类
     * @author kai
     * @date 2018/4/27 16:35
     * @param []
     * @return void
     */
    @Test
    public void testWithFacade(){
        FacadeMode facadeMode = new FacadeMode(new Sports(), new GameNews(), new Entertainment());
        facadeMode.facadeRead();
        facadeMode.facadeClose();
    }
}
