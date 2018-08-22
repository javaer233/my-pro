package designPattern.singleton;

/**
 * @Author kai
 * @Description 单例进阶实现
 * @Create 2018-04-27 17:05
 * 对象创建时机可控
 **/
class BetterSingleton {
    //防止指令重排导致的多次创建对象
    private static volatile BetterSingleton betterSingleton = null;
    private BetterSingleton(){}//私有化构造器
    //静态工厂方法
    public static BetterSingleton getInstance(){
        if (betterSingleton == null) {//双重检测机制
            synchronized (BetterSingleton.class) {//同步锁
                if (betterSingleton == null) {//双重检测机制
                    betterSingleton = new BetterSingleton();
                }
            }
        }
        return betterSingleton;
    }
}
