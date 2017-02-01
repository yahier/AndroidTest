package design.decorate;

/**
 * Created by yahier on 17/1/26.
 */

/**
 *测试装试着模式
 */
public class Test {
    public static void main(String[] args){
        People people = new People(new Monkey());
        //怎么可以调用Monkey的eatBanana()方法
        people.eat();

    }
}
