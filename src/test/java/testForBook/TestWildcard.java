package testForBook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author kai
 * @Description
 * @Create 2018-04-28 16:20
 **/
public class TestWildcard {
    void test1(List<Object> list){
        System.out.println(list);
    }
    void test2(Object object){
        System.out.println(object);
    }

    void test3(List<?> list){
        System.out.println(list);
    }
    /**
     * 虽然Integer是Object的子类，但是List<Integer>不是List<Object>的子类
     */
    @Test
    public void test(){
        List<Integer> integers = new ArrayList<>();
//        test1(integers);
        test2("qewer");
        test3(integers);
    }


}
