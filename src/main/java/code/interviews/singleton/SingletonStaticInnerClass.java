package code.interviews.singleton;

/**
 * 单例模式，利用静态内部类实现，线程安全，推荐使用，但在反序列化时,如果没有声明 readResolve()方法会得到新的对象.
 *
 * @author haroldcoding
 * @create 2017/07/08/10:17
 */
public class SingletonStaticInnerClass {
    
    private SingletonStaticInnerClass() {
    }
    
    private static class SingletonInstanceHolder {
        
        private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
    }
    
    public static SingletonStaticInnerClass getInstance() {
        return SingletonInstanceHolder.INSTANCE;
    }
    
    private Object readResolve() {
        return SingletonInstanceHolder.INSTANCE;
    }
}
