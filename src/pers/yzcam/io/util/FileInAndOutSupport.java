package pers.yzcam.io.util;

import java.io.*;

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
}
