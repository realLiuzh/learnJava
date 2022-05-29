import java.io.File;

/**
 * 文件过滤器
 *
 * @author 志昊的刘
 * @date 2022/5/30
 */
public class FIlenameFilterTest {
    public static void main(String[] args) {
        File file = new File(".");
        String[] list = file.list(((dir, name) -> name.endsWith(".java") || new File(name).isDirectory()));
        for (String name : list) {
            System.out.println(name);
        }
    }
}
