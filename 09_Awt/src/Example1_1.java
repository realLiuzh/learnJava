import javax.swing.*;
import java.awt.*;

/**
 * @author 志昊的刘
 * @date 2022/6/15
 */
public class Example1_1 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("第一个窗口");
        frame.setBounds(100, 100, 400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setLocation(0,0);
        jMenuBar.setSize(400,100);
//        jMenuBar.setBackground();

        JMenu menu1 = new JMenu("第一个菜单");
        menu1.setBackground(Color.RED);
        // 文本左右对齐属性
        menu1.setHorizontalAlignment(SwingConstants.CENTER);

        JMenu menu2=new JMenu("红绿灯");
        JMenu menu3=new JMenu("汽车");
        menu2.setHorizontalAlignment(SwingConstants.LEFT);
        jMenuBar.add(menu1);
        jMenuBar.add(menu2);
        jMenuBar.add(menu3);
        frame.getContentPane().add(jMenuBar);

    }
}
