package errorAndException;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author kai
 * @Description 断言关键字，可以在项目上线时统一去掉这些校验，用于测试
 * @Create 2018-05-11 9:17
 **/
public class TestAssert {
    @Test
    public void test1(){
//        assert 1<0;
        assert 1<0:"这样是不对的";
        System.out.println(1);
    }

    @Test
    public void test2(){
        Arrays.sort(new int[1]);
    }
}
