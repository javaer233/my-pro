package test1;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @Author kai
 * @Description assert test
 * @Create 2018-05-10 10:30
 **/
public class TestAssert {

    @Test
    public void test1(){
        Assert.notNull("Resource is required");
    }
}
