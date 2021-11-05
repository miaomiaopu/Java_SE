package pers.yzcam.systemclass.test;

import pers.yzcam.systemclass.pojo.User;

import java.util.Map;
import java.util.Set;
import java.util.Properties;

public class SystemClassTest {

    public static void main(String[] args) {

        User[] userList = new User[100000];
        // 开始时间
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            userList[i] = new User("用户" + i);
        }
        // 结束时间
        long end = System.currentTimeMillis();
        System.out.println("存储100000个User对象用时 " + (end - begin) + " 毫秒");

        // 查看系统 JVM 信息
        Properties properties = System.getProperties();

        String propertiesString = properties.toString();
        String[] propertiesStringList = propertiesString.split(", ");
        for (String out : propertiesStringList) {
            System.out.println(out);
        }

        // 复制数组
        Integer[] src = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] dest = new Integer[src.length - 2];

        System.arraycopy(src, 1, dest, 0, dest.length);
        for (Integer integer : dest) {
            System.out.print(integer + " ");
        }
        System.out.println();

        // System获取本地计算机信息
        Map<String, String> map = System.getenv();
        Set<String> keyList = map.keySet();
        for (String key : keyList) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
