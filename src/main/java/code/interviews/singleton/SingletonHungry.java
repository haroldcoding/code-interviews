package code.interviews.singleton;

/**
 * 单例模式，饿汉式,线程安全.
 *
 * @author haroldcoding
 * @create 2017/07/08/9:55
 */
public class SingletonHungry {
    
    private static final SingletonHungry INSTANCE = new SingletonHungry();
    
    private SingletonHungry() {
    }
    
    public static SingletonHungry getInstance() {
        return INSTANCE;
    }
    
    /**
     * 解决反序列化时获得新实例的问题.
     */
    private Object readResolve() {
        return INSTANCE;
    }
}
