package pers.yzcam.io.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.io.entity.User;
import pers.yzcam.io.util.FileInAndOutSupport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

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

    @Test
    void useCharInputStreamTest() {
        File file = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\info.ini");
        FileInAndOutSupport.useCharInputStream(file);
    }

    @Test
    void readUserInfoFromFileTest() {
        File file = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\UsersInfo.txt");
        List<User> userList = FileInAndOutSupport.readUserInfoFromFile(file);
        for (User user : userList) {
            System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getGender() + "\t" + new SimpleDateFormat("yyyy-MM-dd").format(user.getBirth()) + "\t" + user.getAddress());
        }
    }

    @Test
    void saveContentToFileTest() {
        String s = "yzcam\t" + "miaomiaopu\r" + "yzcam=miaomiaopu\n";
        File file = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\myself.txt");
        FileInAndOutSupport.saveContentToFile(s, file);
    }

    @Test
    void copyFileTest() {
        File source = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\info.ini");
        File target = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\info(1).ini");
        System.out.println(FileInAndOutSupport.copyFile(source, target));
    }

    @Test
    void copyTextFileTest() {
        File source = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\info.ini");
        File target = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\copy\\info.ini");
        System.out.println(FileInAndOutSupport.copyTextFile(source, target));
    }
}
