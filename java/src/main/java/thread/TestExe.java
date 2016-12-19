package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * volatile没有测试出效果
 * @author lenovo
 *
 */
public class TestExe {
	volatile static int a = 1;
	public static void main(String[] args) {
		TestExe my = new TestExe();
		//my.test();
		my.testVolatile();
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("a is "+a);
		}
	}

	void test() {
		ExecutorService exe = Executors.newCachedThreadPool();
		for (int i = 0; i < 1000; i++) {
			exe.execute(run);
		}

	}

	Runnable run = new Runnable() {
		public void run() {
			System.out.println(13);
			
		};
	};
	
	
	void testVolatile(){
		for(int i=0;i<5;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(2000);
						a++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}