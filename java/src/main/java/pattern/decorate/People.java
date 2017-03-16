package pattern.decorate;

/**
 * Created by yahier on 17/1/26.
 */

public class People  implements IEat {

    private IEat eat;

    public People(IEat eat) {
        this.eat = eat;
    }


    public void eat() {
        this.eat.eat();
        eatRice();
    }


    public void eatRice() {
        System.out.println("people吃米饭");
    }

}
