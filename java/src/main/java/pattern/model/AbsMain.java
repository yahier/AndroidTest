package pattern.model;

/**
 * Created by yahier on 12/19/18.
 */

public abstract class AbsMain {

    public void execute() {
        new Thread(() -> {
            method1();
            method2();
            method3();
        }).start();
    }

    protected abstract void method1();

    protected abstract void method2();

    protected abstract void method3();
}
