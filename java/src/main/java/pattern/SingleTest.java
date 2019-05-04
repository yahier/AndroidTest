package pattern;

public class SingleTest {
    private SingleTest() {
        System.out.println("Single1被创造出来");
    }

    /**
     * 静态代码块和静态构造函数都会先执行
     */
    static SingleTest sin = new SingleTest();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Test3.getInstance();
            }).start();
        }

        //StaticSin.getInstance();
        //Single.test();

        //double a = 1.23;
        //System.out.println(a);
    }

}

class Test1 {
    private Test1() {
        System.out.println("create");
    }

    private static Test1 sin = new Test1();

    public static Test1 getInstance() {
        return sin;
    }

    public static void test() {
        System.out.println("test");
    }
}

// 多线程时 速度不够了
class Test2 {
    Test2() {
        System.out.println("create");
    }

    private static Test2 sin;

    public static synchronized Test2 get() {
        if (sin == null) {
            sin = new Test2();
        }
        return sin;
    }

    static void t() {
        System.out.println("hello");
    }
}

/**
 * 最优化的单例模式方法
 */
class Test3 {
    private Test3() {
        System.out.println("Test3 create");
    }

    private static class SingleHolder {
        private static Test3 sin = new Test3();
    }

    public static Test3 getInstance() {
        return SingleHolder.sin;
    }

    public static void t() {
        System.out.println("test");
    }
}