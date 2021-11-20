package pers.yzcam.fileclass.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.fileclass.util.FileSupport;

import java.io.File;
import java.io.IOException;

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
}
