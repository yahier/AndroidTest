package thread;

/**
 * 测试线程优先级，只有大概的总结。不能严格依靠线程来制定优先级
 */
public class TestPriorityState {

    public static void main(String[] args) {
        testState();
        //testPriority();
    }

    /**
     * 测试thread的优先级
     */
    static void testPriority() {
        for (int i = 1; i < 11; i++) {
            final int j = i;
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println("run1 " + j);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("run2 " + j);
                }
            });

            thread.setPriority(i);
            thread.start();


        }
    }


    /**
     *   测试thread的状态
     */
    static void testState() {
        final Thread mThread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("不要搞事情啊");
                        Thread.sleep(10);

                        for (int j = 0; j < 10000000; j++) {
                            String s = "" + j;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        });


        mThread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 8; i++) {
                    if (mThread.getState() == Thread.State.NEW) {
                        System.out.println("new");
                    } else if (mThread.getState() == Thread.State.RUNNABLE) {
                        System.out.println("RUNNABLE");
                    } else if (mThread.getState() == Thread.State.BLOCKED) {
                        System.out.println("BLOCKED");
                    } else if (mThread.getState() == Thread.State.TERMINATED) {
                        System.out.println("TERMINATED");
                    } else if (mThread.getState() == Thread.State.WAITING) {
                        System.out.println("WAITING");
                    } else if (mThread.getState() == Thread.State.TIMED_WAITING) {
                        System.out.println("TIMED_WAITING");
                    } else {
                        System.out.println("其它状态");
                    }


                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }).start();


    }
}
