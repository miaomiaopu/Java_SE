package pers.yzcam.io.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.io.entity.User;
import pers.yzcam.io.util.FileInAndOutSupport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Test
    void serializableObjectTest() {
        File file = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\users.ser");

        List<User> userList = new ArrayList<>();
        userList.add(new User("Uid00001", "小刚", "男", new Date(), "北京"));
        userList.add(new User("Uid00002", "小红", "女", new Date(), "上海"));
        userList.add(new User("Uid00003", "小井", "女", new Date(), "湖北"));

        FileInAndOutSupport.serializableObject(userList, file);
    }

    @Test
    void deserializationReaderTest() {
        File file = new File("D:\\Java_Code\\Java_SE\\src\\pers\\yzcam\\io\\file\\users.ser");
        List<User> userList = FileInAndOutSupport.deserializationReader(file);
        for (User user : userList) {
            System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getGender() + "\t" + User.getDec());
        }
    }
}
