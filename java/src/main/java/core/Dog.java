package core;

/**
 * Created by yahier on 12/24/18.
 * 测试子类和父类的静态变量的执行顺序 当然是父类-子类
 */

public class Dog extends Animal{
    static {
        System.out.println("dog static");
    }

    public static void main(String[] args){
        System.out.println("dog main");
    }
}
