package pers.yzcam.fileclass.constructor;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author cat
 */
public class FileConstructorTest {
    public static void main(String[] args) {
        File file1 = new File("d:/files/CarNames.txt");
        System.out.println(file1.exists());

        File dir = new File("c:/files/");
        File file2 = new File(dir, "d:/files/CarNames.txt");
        System.out.println(file2.getAbsolutePath());

        try {
            /*
            URI 作为构建 File 对象的参数必须保证其字符串描述前缀为 file
            而且路径分隔符必须为 '/'
             */
            URI uri = new URI("file:/files/");
            File file3 = new File(uri);
            System.out.println(file3.getAbsolutePath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
