package test1;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author kai
 * @Description
 * @Create 2018-05-15 17:25
 **/
public class Test1 {
    @Test
    public void test1(){
        File file = new File("d:/aaa.txt");
        System.out.println(file.mkdir());
    }
}
