package io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * @Author kai
 * @Description
 * @Create 2018-05-14 10:23
 **/
public class TestStream2 {
    /**
     * @Title: test1
     * @Description: 查看当前支持的字符编码集
     * @author kai
     * @date 2018/5/14 17:23
     * @param []
     * @return void
     */
    @Test
    public void test1(){
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        for (String name : stringCharsetSortedMap.keySet()) {
            System.out.println(name);
        }
    }

    /**
     * @Title: test2
     * @Description: 是否将缓存的内容立即写入
     * @author kai
     * @date 2018/5/14 17:23
     * @param []
     * @return void
     */
    @Test
    public void test2() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("d:/220Mysql.txt"),true);
        printWriter.write(123);
//        printWriter.flush();
        printWriter.println();
        printWriter.write(2245);
        printWriter.println();
    }
}
