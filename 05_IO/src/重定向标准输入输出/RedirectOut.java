package 重定向标准输入输出;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author 志昊的刘
 * @date 2022/6/5
 */
public class RedirectOut {
    public static void main(String[] args) {


        try (
                PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))) {
            System.setOut(ps);
            System.out.println("普通字符串");
            System.out.println(new

                    RedirectOut());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
