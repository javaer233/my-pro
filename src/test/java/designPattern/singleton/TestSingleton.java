package designPattern.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Delayed;

/**
 * @Author kai
 * @Description 单例测试类
 * @Create 2018-04-27 17:14
 **/
public class TestSingleton {
    @Test
    public void test1(){
        EnumSingleton instance = EnumSingleton.INSTANCE;
        System.out.println(instance);
    }

    /**
     * 使用反射打破静态内部类实现的单例
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<StaticSingleton> declaredConstructor = StaticSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        StaticSingleton singleton1 = declaredConstructor.newInstance();
        StaticSingleton singleton2 = declaredConstructor.newInstance();
        System.out.println(singleton1.equals(singleton2));
    }

    /**
     * 反射打破饿汉式单例
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<BetterSingleton> declaredConstructor = BetterSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BetterSingleton singleton1 = declaredConstructor.newInstance();
        BetterSingleton singleton2 = declaredConstructor.newInstance();
        System.out.println(singleton1.equals(singleton2));
    }
}
