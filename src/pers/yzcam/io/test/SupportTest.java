package pers.yzcam.io.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.io.util.FileInAndOutSupport;

import java.io.File;

/**
 * @author cat
 */
public class SupportTest {
    @Test
    void readTest() {
        File file = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\info.ini");
        /*
        测试代码
        FileInAndOutSupport.readFile(file); /// 无参 read 方法测试
        FileInAndOutSupport.readStoreToByteArray(file); /// 有参 read 方法测试 (byte[])
         */
        FileInAndOutSupport.readStoreToByteArrayByOffAndLength(file);
    }

    @Test
    void bufferedInputStreamTest() {
        File file = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\info.ini");
        System.out.println(FileInAndOutSupport.useBufferedInputStream(file));
    }
}
