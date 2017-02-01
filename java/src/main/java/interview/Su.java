package interview;

/**
 * 对第二段的测试结果,依然困惑
 */
class ya {
    int a = 0;
}

public class Su extends ya {
    public static void main(String[] args) {

        //第一段测试
        Su s = new Su();
        s.t();
        System.out.println("1:" + s.a);
        //第二段的测试
        int b = 1;
        s.t1(b);
        System.out.println("2:" + b);

    }

    void t() {
        a = 4;
    }

    void t1(int b) {
        b = 3;
        System.out.println("3:" + b);
    }
}
