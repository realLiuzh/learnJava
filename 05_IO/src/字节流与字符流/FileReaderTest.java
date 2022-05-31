package 字节流与字符流;

import java.io.FileReader;
import java.io.IOException;

/**
 * 输入方式与字节流类似
 * @author 志昊的刘
 * @date 2022/5/30
 */
public class FileReaderTest {
    public static void main(String[] args) {
        try (
                FileReader fr = new FileReader("05_IO/src/字节流与字符流/FileReaderTest.java")
        ) {
            char[] chars = new char[32];
            int hasRead = 0;
            while ((hasRead = fr.read(chars)) > 0) {
                System.out.println(new String(chars, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
