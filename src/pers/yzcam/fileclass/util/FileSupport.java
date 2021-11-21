package pers.yzcam.fileclass.util;

import pers.yzcam.fileclass.exception.NotDirectoryException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

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

    /**
     * 根据给定的路径计算包含的子文件数目，文件数目和子目录数目
     *
     * @param dirPath 目录路径
     * @return Map (sumKey = 包含子文件数目; fileKey = 文件数目; dirKey = 子目录数目)
     */
    public static Map<String, Integer> countDirContainsFiles(String dirPath)
            throws FileNotFoundException, NotDirectoryException {
        Map<String, Integer> map = new HashMap<>(3);
        File dir = new File(dirPath);
        if (!dir.exists()) {
            throw new FileNotFoundException("目录不存在");
        }
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            Integer fileSum = 0;
            Integer dirSum = 0;
            for (File file : Objects.requireNonNull(files)) {
                if (file.isFile()) {
                    fileSum++;
                } else {
                    dirSum++;
                }
            }
            map = new HashMap<>(3);
            map.put("sumKey", fileSum + dirSum);
            map.put("fileKey", fileSum);
            map.put("dirKey", dirSum);
            return map;
        } else {
            throw new NotDirectoryException("此路径不是一个目录路径");
        }
    }

    /**
     * 扫描目录，删除 exe 和 msi 文件，并且返回名称
     *
     * @param dir 目录对象
     * @return (List)名称集合
     */
    public static List<String> scanningFolder(File dir)
            throws FileNotFoundException, NotDirectoryException {
        List<String> fileList = new ArrayList<>();
        if (!dir.exists()) {
            throw new FileNotFoundException("目录不存在");
        }
        if (dir.isFile()) {
            throw new NotDirectoryException("目标对象不是有效目录");
        }
        File[] files = dir.listFiles();
        for (File file : Objects.requireNonNull(files)) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.endsWith(".exe") || fileName.endsWith(".msi")) {
                    if (file.delete()) {
                        fileList.add(fileName);
                    }
                }
            }
        }
        return fileList;
    }
}
