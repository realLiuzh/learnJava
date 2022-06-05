package IO流体系;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * PrintStream包装节点流OutStream
 *
 * @author 志昊的刘
 * @date 2022/6/5
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        try (
                FileOutputStream fos = new FileOutputStream("test.txt");
                PrintStream ps = new PrintStream(fos)
        ) {
            // 使用PrintStream执行输出
            ps.println("普通字符串");
            // PrintStream输出对象
            ps.println(new PrintStreamTest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
