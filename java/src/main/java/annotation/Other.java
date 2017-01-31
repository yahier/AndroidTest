package annotation;

public class Other {

    int a = 2;

    @Bingo(num = 2)
    public void doOther() {

    }


    private int v() {
        System.out.println("Other v");
        return 33;
    }

    //测试用反射来调用这个方法
    private int add(int a, int b) {
        return a + b;
    }
}
