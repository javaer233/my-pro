package designPattern.singleton;

/**
 * @Author kai
 * @Description 单例进阶实现
 * @Create 2018-04-27 17:05
 * 对象创建时机可控
 **/
class BetterSingleton {
    private static volatile BetterSingleton betterSingleton = null;
    private BetterSingleton(){}
    public static BetterSingleton getInstance(){
        if (betterSingleton == null) {
            synchronized (BetterSingleton.class) {
                if (betterSingleton == null) {
                    betterSingleton = new BetterSingleton();
                }
            }
        }
        return betterSingleton;
    }
}
