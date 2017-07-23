package code.interviews.singleton;

/**
 * 单例模式，懒汉式，线程安全实现，效率不高
 *
 * @author haroldcoding
 * @create 2017/07/08/10:00
 */
public class SingletonLazySynchronized {
    
    private static SingletonLazySynchronized instance = null;
    
    private SingletonLazySynchronized() {
    }
    
    public static synchronized SingletonLazySynchronized getInstance() {
        if (null == instance) {
            instance = new SingletonLazySynchronized();
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
