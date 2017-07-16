package pattern;

public class Single1 {
    private Single1() {
        System.out.println("Single1被创造出来");
    }

    /**
     * 静态代码块和静态构造函数都会先执行
     */
    static Single1 sin = new Single1();

    public static void main(String[] args) {
        Sin.t();
        StaticSin.getInstance();
        //StaticSin.getInstance();
        //Single.test();

        //double a = 1.23;
        //System.out.println(a);
    }

}

class Single {
    private Single() {
        System.out.println("create");
    }

    private static Single sin = new Single();

    public static Single getInstance() {
        return sin;
    }

    public static void test() {
        System.out.println("test");
        //junit.Assert
    }
}

// 多线程时 速度不够了
class Sin {
    Sin() {
        System.out.println("create");
    }

    private Sin sin;

    public synchronized Sin get() {
        if (sin == null) {
            sin = new Sin();
        }
        return sin;
    }

    static void t() {
        System.out.println("hello");
    }
}

// 最优化的单例模式方法
class StaticSin {
    private StaticSin() {
        System.out.println("staticSin create");
    }

    private static class SingleHolder {
        private static StaticSin sin = new StaticSin();
    }

    public static StaticSin getInstance() {
        return SingleHolder.sin;
    }

    public static void t() {
        System.out.println("test");
    }
}