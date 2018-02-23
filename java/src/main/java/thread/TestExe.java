package thread;

/**
 * @author lenovo
 */
public class TestExe {

    private class ReaderThread extends Thread {
        private boolean stop = false;//若此处加上volatile关键字，则可以终止线程的run方法

        public void stopMe() {
            stop = true;
        }

        @Override
        public void run() {
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println("stop thread");
        }
    }

    public static void main(String[] args) {
        TestExe testExe = new TestExe();
        ReaderThread thread = testExe.new ReaderThread();
        thread.start();

        try {
            Thread.sleep(500);
            thread.stopMe();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}