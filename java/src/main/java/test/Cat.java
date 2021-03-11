package test;

public class Cat extends Animal implements OnActionListener{
    String name;


    public Cat(String name) {
        super("cat");
    }


    private void test() {
        String name = "bingo";
        String age = "18";
        String result = name + age;
    }

    @Override
    public void onGoing() {
        //a = 9;

    }
}
