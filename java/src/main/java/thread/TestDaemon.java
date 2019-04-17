package thread;

/**
 * 用户线程结束后，守护线程会自动退出
 */
public class TestDaemon {
    public static void main(String[] args) {
        TestDaemon test = new TestDaemon();

        for (int i = 0; i < 3; i++) {
            MyThread thread = test.new MyThread(i);
            if (i == 1) {
                //看效果的话,直接打开或者注释这一句就可以了。
                thread.setDaemon(true);
            }
            thread.start();
        }

    }

    class MyThread extends Thread {
        int index;

        public MyThread(int index) {
            this.index = index;

        }

        @Override
        public void run() {
            System.out.println("run index:" + index);
            while (index == 0) {
                try {
                    Thread.sleep(500);
                    System.out.println("index:" + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    class H implements Runnable {

        @Override
        public void run() {
            System.out.println("H run");


        }
    }
}
