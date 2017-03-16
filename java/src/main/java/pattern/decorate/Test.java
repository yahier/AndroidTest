package pattern.decorate;

/**
 * Created by yahier on 17/1/26.
 */

/**
 *测试装试着模式.装试着模式是代理模式的一个变种。依然实现相同的接口
 */
public class Test {
    public static void main(String[] args){
        People people = new People(new Monkey(new Animal()));
        //怎么可以调用Monkey的eatBanana()方法
        people.eat();

    }
}
