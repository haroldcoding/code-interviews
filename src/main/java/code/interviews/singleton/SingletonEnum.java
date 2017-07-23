package code.interviews.singleton;

/**
 * 单例模式，利用枚举实现，线程安全，并且防止反序列化重新创建新的对象.
 * @author haroldcoding
 * @create 2017/07/08/10:35
 */
public enum SingletonEnum {
    INSTANCE;
}
