package test;

public class Test12 extends Thread{
    public static void main(String[] args){
        Test12 test12 = new Test12();
        test12.start();

    }

    public void run(){
        System.out.println("running");
        float f = (float)1.4;
        double d = 23.45d;
    }


}
