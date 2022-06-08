package 深入泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 志昊的刘
 * @date 2022/6/6
 */
public class Apple<T> {
    private T info;

    public Apple() {
    }

    public Apple(T info) {
        this.info = info;
    }

    public static void fun(List list){

    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args) {
        Apple<String> apple1 = new Apple<>("苹果");
        System.out.println(apple1.getInfo());

        fun(new ArrayList<String>());

        Apple<Double> apple2 = new Apple<>(6.57);
        System.out.println(apple2.getInfo());
    }
}
