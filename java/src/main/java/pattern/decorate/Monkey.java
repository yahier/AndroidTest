package pattern.decorate;

/**
 * Created by yahier on 17/1/26.
 */

public class Monkey implements IEat {
    public IEat eat;

    public Monkey(IEat eat) {
        this.eat = eat;
    }

    public void eat() {
        eat.eat();
        this.eatBanana();
    }

    public void eatBanana() {
        System.out.println("猴子吃香蕉");
    }
}
