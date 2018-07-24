package designPattern.singleton;

import org.junit.Test;

/**
 * @Author kai
 * @Description 单例测试类
 * @Create 2018-04-27 17:14
 **/
public class TestSingleton {
    @Test
    public void test1(){
        EnumSingleton instance = EnumSingleton.INSTANCE;
        System.out.println(instance);
    }

}
