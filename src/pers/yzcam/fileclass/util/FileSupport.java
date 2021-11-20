package pers.yzcam.fileclass.util;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author cat
 */
public class FileSupport {
    /**
     * 通过给定的文件路径创建 File 对象
     *
     * @param filePath 文件路径
     * @return File 对象
     */
    public static File createFile(String filePath) {
        return new File(filePath);
    }

    /**
     * 显示目标文件 file 的信息
     *
     * @param file 文件对象
     */
    public static void displayFileInfo(File file) throws IOException {
        System.out.println(file.exists() ? "文件存在" : "文件不存在");
        System.out.println(file.canRead() ? "文件可读" : "文件不可读");
        System.out.println(file.canWrite() ? "文件可写" : "文件不可写");
        System.out.println(file.delete() ? "文件已删除" : "文件删除失败");
        System.out.println(file.createNewFile() ? "文件创建成功" : "文件创建失败");
    }

    /**
     * 显示目标文件 file 的路径和名称信息
     *
     * @param file 文件对象
     */
    public static void displayFileMessage(File file) {
        System.out.println("文件绝对路径 " + file.getAbsolutePath());
        System.out.println("文件名称 " + file.getName());
        System.out.println("文件路径 " + file.getPath());
        System.out.println("文件父路径 " + file.getParent());
        System.out.println("File对象是否为文件? " + file.isFile());
        System.out.println("File对象是否为目录? " + file.isDirectory());
    }

    /**
     * 统计给定的 File 对象为目录时此目录下文件和子目录数目
     *
     * @param file 目录对象
     * @return 文件和目录数目
     */
    public static int countFileAndDirSumInFile(File file) {
        if (file.isDirectory()) {
            return Objects.requireNonNull(file.listFiles()).length;
        }
        return -1;
    }

    /**
     * 根据给定的路径创建目录
     *
     * @param dirPath 目录路径
     * @return 是否创建成功
     */
    public static boolean createFolder(String dirPath) {
        boolean bool = false;
        File dir = new File(dirPath);
        // bool =dir.mkdir(); /// 创建目录
        bool = dir.mkdirs();
        return bool;
    }
}
