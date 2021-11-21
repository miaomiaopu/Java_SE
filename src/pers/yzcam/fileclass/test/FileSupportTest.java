package pers.yzcam.fileclass.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.fileclass.exception.NotDirectoryException;
import pers.yzcam.fileclass.util.FileSupport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author cat
 */
public class FileSupportTest {
    @Test
    void fileSupportTest() {
        String filePath = "D:/Java_Code/Java_SE/src/pers/yzcam/fileclass/file/CarNames.txt";
        File file = FileSupport.createFile(filePath);
        try {
            FileSupport.displayFileInfo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileSupport.displayFileMessage(file);
    }

    @Test
    void countFileAndDirSumInFileTest() {
        String filePath = "D:/Java_Code/Java_SE/src/pers/yzcam/fileclass/file";
        File file = FileSupport.createFile(filePath);
        System.out.println(FileSupport.countFileAndDirSumInFile(file));
    }

    @Test
    void createFolderTest() {
        String filePath = "D:/Java_Code/Java_SE/src/pers/yzcam/fileclass/file/target";
        System.out.println("是否创建成功? " + FileSupport.createFolder(filePath));
    }

    @Test
    void countDirContainsFilesTest() {
        Map<String, Integer> map;
        try {
            map = FileSupport.countDirContainsFiles("D:/Java_Code/Java_SE/src/pers/yzcam/fileclass/file");
            System.out.println(map.get("sumKey"));
            System.out.println(map.get("fileKey"));
            System.out.println(map.get("dirKey"));
        } catch (FileNotFoundException | NotDirectoryException e) {
            e.printStackTrace();
        }
    }

    @Test
    void scanningFolderTest() {
        try {
            List<String> fileNameList = FileSupport.scanningFolder(new File("D:/Java_Code/Java_SE/src/pers/yzcam/fileclass/file"));
            System.out.println("被删除的文件信息");
            for (String s : fileNameList) {
                System.out.println(s);
            }
        } catch (FileNotFoundException | NotDirectoryException e) {
            e.printStackTrace();
        }
    }
}
