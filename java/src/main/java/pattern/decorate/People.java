package pattern.decorate;

/**
 * Created by yahier on 17/1/26.
 */

public class People extends Animal {

    private Animal animal;

    public People(Animal animal) {
        this.animal = animal;
    }


    public void eat() {
        this.animal.eat();
        think();
    }


    public void think() {
        System.out.println("people think");
    }

}
