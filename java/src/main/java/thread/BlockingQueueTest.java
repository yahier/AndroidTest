package thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by yahier on 10/29/18.
 *
 * 生产者-消费者的解决方案 ArrayBlockingQueue.
 * 1)测试发现，如果线程不sleep 基本上是写满-取完-写满-取完的逻辑，如果sleep(1000),基本上是有消息马上就被读完了
 */

public class BlockingQueueTest {
    private int size = 20;
    //一旦创建，容量不会改变
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(size, false);

    public static void main(String[] args) {
        BlockingQueueTest test = new BlockingQueueTest();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    //从阻塞队列中取出一个元素
                    queue.take();
                    System.out.println("————————" + queue.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    //向阻塞队列中插入一个元素
                    queue.put(1);
                    System.out.println("........" + queue.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

