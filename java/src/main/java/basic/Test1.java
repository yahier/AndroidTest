package basic;

public class Test1 {
    public static void main(String[] args) {
        People people = new People();
        //people.eat();
        people.drink();

        int a = 18 & 2;
        System.out.println("a is:" + a);

    }

}

class Animal {
    public void eat() {
        System.out.println("动物吃东西");
    }

    public void drink() {
        System.out.println("动物喝东西");
        eat();//todo 执行的是   子类的方法
    }

}

class People extends Animal {
    @Override
    public void eat() {
        System.out.println("人在吃饭");
    }
}
