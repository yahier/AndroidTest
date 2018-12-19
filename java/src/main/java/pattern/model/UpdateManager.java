package pattern.model;

/**
 * Created by yahier on 12/19/18.
 */

public class UpdateManager extends AbsMain {
    private final String TAG = "UpdateManager ";

    @Override
    protected void method1() {
        System.err.println(TAG + "method1 开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(TAG + "method1 结束");
    }

    @Override
    protected void method2() {
        System.err.println(TAG + "method2 开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(TAG + "method2 结束");
    }

    @Override
    protected void method3() {
        System.err.println(TAG + "method3 开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(TAG + "method3 结束");
    }
}
