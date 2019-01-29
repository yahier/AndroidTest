package fanxing;

/**
 * Created by yahier on 1/29/19.
 */

class FruitGenerator<T> implements IGenerator<T> {
    @Override
    public T next(T t) {
        return t;
    }



}
