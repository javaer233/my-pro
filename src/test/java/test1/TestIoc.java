package test1;

import com.fy.bean.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author kai
 * @Description spring注入对象
 * @Create 2018-04-24 16:24
 **/
//@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)
//@ContextConfiguration("classpath:spring.xml")
public class TestIoc {
//    @Autowired
//    Teacher teacher;

    @Test
    public void test1(){
//        System.out.println(teacher);
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring.xml");
        Object teacher = applicationContext.getBean("teacher");
//        Object teacher2 = applicationContext.getBean("teacher");//重复注入时如何运行？
        System.out.println(teacher);
    }
}
