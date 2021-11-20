package pers.yzcam.sensible;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * @author cat
 */
public class FileManagement {
    /**
     * 将文件保存到目标位置
     *
     * @param file     文件
     * @param filePath 目标位置
     * @throws FileNotFoundException 文件不存在抛出异常
     */
    public void saveFileToTarget(File file, String filePath) throws FileNotFoundException {

        /*
        如果目标文件不存在，抛出 FileNotFoundException 实例
         */
        if (!file.exists()) {
            throw new FileNotFoundException("目标文件不存在请检查参数");
        }
        System.out.println("文件保存到 " + filePath);
    }
}
