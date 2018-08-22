package designPattern.singleton;

/**
 * @Author kai
 * @Description 枚举实现单例
 * @Create 2018-04-27 17:13
 * 简洁易用
 **/
enum EnumSingleton {
    //jvm会阻止反射获取私有构造方法，无法使用反射构造多个对象
    INSTANCE;
}
