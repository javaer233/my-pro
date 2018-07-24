package io;

import org.junit.Test;

import java.io.*;

/**
 * @Author kai
 * @Description 流过滤器的分层
 * @Create 2018-05-14 9:32
 **/
public class TestStream {
    /**
     * @Title: test1
     * @Description: 字节输入流
     * @author kai
     * @date 2018/5/14 17:22
     * @param []
     * @return void
     */
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("d:/220Mysql.txt");
        byte[] bytes = new byte[20];
        int i;
        while ((i=fileInputStream.read(bytes))>0){
            System.out.println(i);
        }
    }
    /**
     * @Title: test2
     * @Description: 流的分层
     * @author kai
     * @date 2018/5/14 17:22
     * @param []
     * @return void
     */
    @Test
    public void test2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("d:/220Mysql.txt");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        double v = dataInputStream.readDouble();
        System.out.println(v);
        byte[] bytes = new byte[10];
        int i;
        while ((i=fileInputStream.read(bytes))>0){
            System.out.println(i);
        }
    }
    /**
     * @Title: test3
     * @Description: 同时对文件进行读写的流（只能本地）
     * @author kai
     * @date 2018/5/14 17:22
     * @param []
     * @return void
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile rw = new RandomAccessFile("d:/220Mysql.txt", "rw");
        long length = rw.length();
        rw.seek(length/2);
        rw.writeByte(11);
        byte b = rw.readByte();
        System.out.println(b);
    }



}
