package pattern.decorate;

/**
 * Created by yahier on 17/1/26.
 */

public class Monkey extends Animal {

    public void eat() {
        super.eat();
        this.eatBanana();
    }

    public void eatBanana() {
        System.out.println("猴子吃香蕉");
    }
}
