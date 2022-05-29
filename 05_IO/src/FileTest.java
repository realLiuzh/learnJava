import java.io.File;
import java.io.IOException;

/**
 * File类基础操作
 *
 * @author 志昊的刘
 * @date 2022/5/29
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        // 当前路径来创建一个File对象
        File file = new File(".");
        // 直接获取文件名 输出: .
        System.out.println(file.getName());
        // 获取相对路径的父路径 输出: null
        System.out.println(file.getParent());
        // 获取绝对路径
        // D:\JavaProjects\202205\learnJava\.
        System.out.println(file.getAbsoluteFile());
        // 获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        // 在当前路径下创建一个文件 文件名：前缀 + 随机数 + 后缀
        File tmpFile = File.createTempFile("aaa", ".txt", file);
        // 当JVM退出时删除该文件
        tmpFile.deleteOnExit();
        // 以系统当前时间作为新文件名来创建新文件
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile对象是否存在：" + newFile.exists());
        // 以指定newFile对象来创建一个文件
        newFile.createNewFile();
        // 以newFile对象来创建一个目录，因为newFile已经存在
        // 所以下面方法返回false，即无法创建该目录
        System.out.println(newFile.mkdir());
        // 使用list()方法列出当前路径下的所有文件和路径
        String[] list = file.list();
        System.out.println("===当前路径下所有文件和路径如下===");
        for (String s : list) {
            System.out.println(s);
        }
        // listRoots()静态方法列出所有的磁盘根路径
        File[] roots = File.listRoots();
        System.out.println("====系统所有根路径如下====");
        for (File root : roots) {
            System.out.println(root);
        }
    }
}
