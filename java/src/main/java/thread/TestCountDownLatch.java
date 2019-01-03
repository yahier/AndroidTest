package thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yahier on 10/8/18.
 * 测试CountDownLatch 关键方法就是await(...)和countDown()
 * 执行await则等待，当countDown()执行一次，数值-1，当数值减至0时，await()方法就被唤醒
 */

public class TestCountDownLatch {
    public static void main(String[] args) {
        TestCountDownLatch test = new TestCountDownLatch();
        Driver driver = test.new Driver();
        driver.main();
    }

    class Driver {
        int N = 5;

        void main() {
            CountDownLatch startSignal = new CountDownLatch(1);
            CountDownLatch doneSignal = new CountDownLatch(N);

            for (int i = 0; i < N; ++i) // create and start threads
                new Thread(new TestCountDownLatch.Worker(startSignal, doneSignal)).start();

            doSomethingElse();            // don't let run yet
            startSignal.countDown();      // let all threads proceed
            doSomethingElse();
            try {
                doneSignal.await();           // wait for all to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main的末尾");

        }

        void doSomethingElse() {
            System.out.println("doSomethingElse");
        }
    }

    class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                startSignal.await();
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException ex) {
                //pass
            }
        }

        void doWork() {
            System.out.println("do work");
        }
    }
}
