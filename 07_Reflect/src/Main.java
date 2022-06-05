import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 志昊的刘
 * @date 2022/6/5
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获取TargetObject类的Class对象并且创建TargetObject实例
        Class<?> targetClass = Class.forName("TargetObject");
        TargetObject to = (TargetObject) targetClass.newInstance();

        // 获取类中的所有方法
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // 获取指定方法并调用
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(to,"眠秋雨");
        // 获取指定参数并修改
        Field field = targetClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(to,"眠秋雨");

        // 调用private方法
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        // 取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(to);

    }
}
