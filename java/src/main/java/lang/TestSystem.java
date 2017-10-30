package lang;

/**
 * Created by yahier on 17/8/21.
 */

public class TestSystem {
    public static final void main(String[] args) {

        test1();

    }

    static void test1() {
        //返回计时器的当前值。与系统时间无关
        System.out.print(System.nanoTime() / 1000000000);//秒 24342 24355 24418 25112 26408
    }

}
