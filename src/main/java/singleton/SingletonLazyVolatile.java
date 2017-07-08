package singleton;

/**
 * 单例模式，懒汉式，利用关键字 volatile 解决双重检查锁线程不安全.
 *
 * @author haroldcoding
 * @create 2017/07/08/10:12
 */
public class SingletonLazyVolatile {
    
    private static volatile SingletonLazyVolatile instance = null;
    
    private SingletonLazyVolatile() {
    }
    
    public static SingletonLazyVolatile getInstance() {
        if (null == instance) {
            synchronized (SingletonLazyVolatile.class) {
                if (null == instance) {
                    instance = new SingletonLazyVolatile();
                }
            }
        }
        return instance;
    }
    /**
     * 解决反序列化时获得新实例的问题.
     */
    private Object readResolve() {
        return instance;
    }
}
