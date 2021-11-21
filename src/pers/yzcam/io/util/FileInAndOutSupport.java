package pers.yzcam.io.util;

import pers.yzcam.io.entity.User;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author cat
 */
public class FileInAndOutSupport {
    /**
     * 二进制输入流读取文件(无参 read 方法)
     *
     * @param file 文件对象
     */
    public static void readFile(File file) {
        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                int count;
                while ((count = inputStream.read()) != -1) {
                    System.out.println("当前想要读一个字节数据的返回的字节值 " + count);
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 二进制输入流读取文件(有参 read 方法、参数为 byte[])
     *
     * @param file 文件对象
     */
    public static void readStoreToByteArray(File file) {
        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[15];
                int count;
                while ((count = inputStream.read(bytes)) != -1) {
                    String str = new String(bytes, 0, count);
                    System.out.println(str);
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 二进制输入流读取文件(有参 read 方法、参数为 byte[],off,len)
     *
     * @param file 文件对象
     */
    public static void readStoreToByteArrayByOffAndLength(File file) {
        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[15];
                int count;
                while ((count = inputStream.read(bytes, 0, bytes.length)) != -1) {
                    String str = new String(bytes, 0, count);
                    System.out.println(str);
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 利用二进制缓冲输入流读取文件
     *
     * @param file 文件对象
     * @return long
     */
    public static long useBufferedInputStream(File file) {
        long size = 0;
        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                byte[] bytes = new byte[1024 * 10];
                int count;
                while ((count = bufferedInputStream.read(bytes, 0, bytes.length)) != -1) {
                    size += count;
                }
                bufferedInputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return size;
    }

    /**
     * 使用字符输入流读取文件
     *
     * @param file 文件对象
     */
    public static void useCharInputStream(File file) {
        if (file.exists()) {
            try {
                Reader reader = new FileReader(file);
                char[] chars = new char[124];
                int count;
                while ((count = reader.read(chars, 0, chars.length)) != -1) {
                    System.out.println(new String(chars, 0, count));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从文件中获取用户信息，并且返回 List 列表
     *
     * @param file 文件对象
     * @return List<User> 用户列表
     */
    public static List<User> readUserInfoFromFile(File file) {
        List<User> userList = new ArrayList<>();
        if (file.exists()) {
            try {
                Reader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String lineStr = "";
                while ((lineStr = bufferedReader.readLine()) != null && !"".equals(lineStr)) {
                    User user = new User();
                    String[] strings = lineStr.split(" ");
                    user.setId(strings[0]);
                    user.setName(strings[1]);
                    user.setGender(strings[2]);
                    try {
                        user.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse(strings[3]));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    user.setAddress(strings[4]);
                    userList.add(user);
                }
                bufferedReader.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return userList;
    }
}
