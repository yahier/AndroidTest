package array;

import java.util.Vector;

/**
 * Created by yahier on 10/8/18.
 */

public class VectorTest {


    private static Vector<Integer> vector = new Vector();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }


            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        Thread.yield();
                        vector.remove(i);//越界
                    }
                }

            });
            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        Thread.yield();
                        System.out.println(vector.get(i));
                    }
                }
            });
            removeThread.start();
            printThread.start();

            while (Thread.activeCount() > 20) ;
        }
    }


}
