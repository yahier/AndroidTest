package fanxing;

/**
 * Created by yahier on 1/29/19.
 * 经典泛型类 also see Invoker.java
 */

public class Generic<T, V> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;
    private V v;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey() { //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

}
