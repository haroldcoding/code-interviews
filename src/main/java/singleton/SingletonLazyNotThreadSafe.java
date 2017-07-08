package singleton;

/**
 * 单例模式，懒汉式，线程不安全.
 *
 * @author haroldcoding
 * @create 2017/07/08/9:58
 */
public class SingletonLazyNotThreadSafe {
    
    private static SingletonLazyNotThreadSafe instance = null;
    
    private SingletonLazyNotThreadSafe() {
    }
    
    public static SingletonLazyNotThreadSafe getInstance() {
        if (null == instance) {
            instance = new SingletonLazyNotThreadSafe();
        }
        return instance;
    }
}
