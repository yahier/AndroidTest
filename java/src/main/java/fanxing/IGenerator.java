package fanxing;

/**
 * Created by yahier on 1/29/19.
 * 泛型接口
 */

public interface IGenerator<T> {
    T next(T key);
}
