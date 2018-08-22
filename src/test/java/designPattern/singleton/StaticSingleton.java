package designPattern.singleton;

/**
 * @Author kai
 * @Description 静态内部类实现单例
 * @Create 2018-04-27 17:18
 * 静态内部类的加载机制保证了单例与线程安全
 **/
public class StaticSingleton {
    //私有化构造器
    private StaticSingleton(){}
    //静态内部类，调用getInstance方法时被加载，然后创建单例对象
    private static class InnerSingleton{
        private static StaticSingleton staticSingleton = new StaticSingleton();
    }
    //从静态内部类获取对象
    public StaticSingleton getInstance(){
        //调用该方法，内部类被加载，此时才会创建该单例对象
        // 利用了classLoader的加载机制实现懒加载（反射仍可以创建多个对象）
        return InnerSingleton.staticSingleton;
    }
}
