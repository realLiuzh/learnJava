package 泛型擦除;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @author 志昊的刘
 * @date 2022/6/6
 */
public class Test {

    // 泛型擦除引发的安全问题
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(594);
        list.getClass().getMethod("add", Object.class).invoke(list, "眠秋雨");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
