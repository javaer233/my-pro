package testForBook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author kai
 * @Description 《java编程语言》题例
 * @Create 2018-04-27 9:49
 **/
//@RunWith(SpringRunner.class)
//@ContextConfiguration("classpath:spring.xml")
public class TestOne {
    @Test
    public void test1 (){
        System.out.printf("The value of Math.PI is %7.3f %n", Math.PI);
    }

    @Test
    public void test2(){
        LocalInnerClazz localInnerClazz = new LocalInnerClazz();
        localInnerClazz.startOne(true);
    }

}
