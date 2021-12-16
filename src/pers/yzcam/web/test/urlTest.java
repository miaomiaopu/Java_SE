package pers.yzcam.web.test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author cat
 */
public class urlTest {
    public static void main(String[] args) {
        try {
            URL url0 = new URL("http", "127.0.0.1", 8080, "index.html");
            URL url1 = new URL("http", "127.0.0.1", "index.html");
            URL url2 = new URL("file", "127.0.0.1", "index.html");
            System.out.println(url0);
            System.out.println(url1);
            System.out.println(url2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
