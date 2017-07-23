package code.interviews.singleton;

/**
 * 单例模式，懒汉式，双重检查锁实现，提高了效率，但线程不安全
 *
 * @author haroldcoding
 * @create 2017/07/08/10:03
 */
public class SingletonLazyDoubleCheck {
    
    private static SingletonLazyDoubleCheck instance = null;
    
    private SingletonLazyDoubleCheck() {
    }
    
    public static SingletonLazyDoubleCheck getInstance() {
        if (null == instance) {
            synchronized (SingletonLazyDoubleCheck.class) {
                if (null == instance) {
                    instance = new SingletonLazyDoubleCheck();
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
