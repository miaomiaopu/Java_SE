package pers.yzcam.sensible.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.sensible.FileManagement;
import pers.yzcam.sensible.exception.TypeNotSupportedException;
import pers.yzcam.sensible.util.TypeManagement;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author cat
 */
public class CaseTest {
    @Test
    void saveFileToTarget() {
        FileManagement fileManagement = new FileManagement();
        File file = new File("z:\\files\\a.txt");
        try {
            fileManagement.saveFileToTarget(file, "z:/files/");
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        } finally {
            System.out.println("必须执行的代码");
        }
    }

    @Test
    void managementTypeTest() {
        File file = new File("z:\\files\\a.txt");
        try {
            new TypeManagement().managementType(file);
        } catch (TypeNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
