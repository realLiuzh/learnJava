package 字节流与字符流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 志昊的刘
 * @date 2022/5/30
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("05_IO/src/字节流与字符流/FileOutputStreamTest.java");
                FileOutputStream fos = new FileOutputStream("newFile.txt")
        ) {
            byte[] bytes = new byte[32];
            int hasRead = 0;
            // 循环从输入流中读取数据
            while ((hasRead = fis.read(bytes)) > 0) {
                fos.write(bytes, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
