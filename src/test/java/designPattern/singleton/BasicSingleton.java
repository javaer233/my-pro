package designPattern.singleton;

/**
 * @Author kai
 * @Description 基础的单例实现
 * @Create 2018-04-27 17:01
 *
 * 初始化速度快，占用内存小
 **/
class BasicSingleton {
    //内部实例化一个对象
    private static BasicSingleton basicSingleton = new BasicSingleton();
    //私有化构造器，外部无法通过new创建实例
    private BasicSingleton(){}
    /**
     * 提供统一的外部访问接口
     */
    public static BasicSingleton getInstance(){
        return basicSingleton;
    }
}
