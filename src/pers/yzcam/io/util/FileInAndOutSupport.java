package pers.yzcam.io.util;

import pers.yzcam.io.entity.User;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
                String lineStr;
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

    /**
     * 将字符串保存到文件中
     *
     * @param content 源字符串
     * @param target  目标文件
     */
    public static void saveContentToFile(String content, File target) {
        if (target != null && target.exists()) {
            byte[] bytes = content.getBytes();
            try {
                OutputStream outputStream = new FileOutputStream(target);
                outputStream.write(bytes);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 间文件内容复制到另一个文件中
     *
     * @param source 源文件
     * @param target 目标文件
     * @return 实际处理的字节数
     */
    public static long copyFile(File source, File target) {
        long length = 0;
        if (source.exists() && target.exists()) {
            try {
                InputStream inputStream = new FileInputStream(source);
                OutputStream outputStream = new FileOutputStream(target);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                byte[] bytes = new byte[1024 * 10];
                int count;
                while ((count = bufferedInputStream.read(bytes, 0, bytes.length)) != -1) {
                    bufferedOutputStream.write(bytes, 0, count);
                    length += count;
                }
                bufferedInputStream.close();
                inputStream.close();
                bufferedOutputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return length;
    }

    /**
     * 将文件内容复制到另一个文件中(用字符输入流)
     *
     * @param source 源文件
     * @param target 目标文件
     * @return 实际处理的字节数
     */
    public static long copyTextFile(File source, File target) {
        long length = 0;
        if (!target.exists()) {
            String parent = target.getParent();
            String name = target.getName();
            File dir = new File(parent);
            boolean flag = dir.mkdirs();
            target = new File(dir.getAbsolutePath() + "/" + name);
            if (flag) {
                System.out.println("父目录创建成功");
            } else {
                System.out.println("父目录创建失败或者父目录已经存在");
            }
        }
        if (source.exists()) {
            try {
                Reader reader = new FileReader(source);
                BufferedReader bufferedReader = new BufferedReader(reader);
                Writer writer = new FileWriter(target);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                char[] chars = new char[1024];
                int count;
                while ((count = bufferedReader.read(chars, 0, chars.length)) != -1) {
                    bufferedWriter.write(chars, 0, count);
                    System.out.println("这次拷贝了 " + count + " 个字符");
                    length += count;
                }
                bufferedWriter.close();
                writer.close();
                bufferedReader.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return length;
    }

    /**
     * 序列化对象保存到目标文件中
     *
     * @param userList 对象列表
     * @param file     目标文件
     */
    public static void serializableObject(List<User> userList, File file) {
        if (!file.exists()) {
            String parent = file.getParent();
            String name = file.getName();
            File dir = new File(parent);
            boolean flag = dir.mkdirs();
            file = new File(dir.getAbsolutePath() + "/" + name);
        }
        if (userList.size() != 0) {
            try {
                OutputStream outputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                for (User user : userList) {
                    User.setDec("我是大学生");
                    objectOutputStream.writeObject(user);
                }
                objectOutputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 反序列化操作读取目标文件中的对象
     *
     * @param file 源文件
     * @return 目标对象列表
     */
    public static List<User> deserializationReader(File file) {
        List<User> userList = new ArrayList<>();
        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Object temp = null;
                try {
                    while ((temp = objectInputStream.readObject()) != null) {
                        if (temp instanceof User) {
                            userList.add((User) temp);
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                objectInputStream.close();
                inputStream.close();
            } catch (IOException e) {
                if (!(e instanceof EOFException)) {
                    e.printStackTrace();
                }
            }
        }
        return userList;
    }
}
