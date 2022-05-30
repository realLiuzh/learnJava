package 字节流与字符流;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 志昊的刘
 * @date 2022/5/30
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流 【相对路径】起始地址为learnJava\
        // 可以理解为相对于Java虚拟机的路径
        FileInputStream fis = new FileInputStream("05_IO\\src\\字节流与字符流.FileInputStreamTest.java");
        // 创建一个长度为1024的竹筒
        byte[] bytes = new byte[1024];
        // 用于实际保存的字节数
        int hasRead = 0;
        // 使用循环来重复读取数据
        while ((hasRead = fis.read(bytes)) > 0) {
            // 取出字节，并将字节数组转换成字符串输出
            System.out.println(new String(bytes, 0, hasRead));
        }
        //关闭文件输入流，放在finally块内更安全
        fis.close();
    }
}
