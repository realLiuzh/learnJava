package 泛型入门;

import java.util.ArrayList;

/**
 * 不用泛型不安全，而且麻烦
 * @author 志昊的刘
 * @date 2022/6/6
 */
public class ListErr {
//
//    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
//        list.add("眠秋雨");
//        list.add("不用泛型的情况");
////        list.add(4);
//        list.forEach(str -> System.out.println(((String) str).length()));
//
//    }

    // 使用泛型后，编译时会检查
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("眠秋雨");
        list.add("不用泛型的情况");
//        list.add(4);
        list.forEach(str -> System.out.println((str).length()));

    }
}
