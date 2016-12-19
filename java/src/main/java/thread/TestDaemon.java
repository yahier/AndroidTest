package thread;

/**
 * 用户线程结束后，守护线程会自动退出
 *
 */
public class TestDaemon {
	public static void main(String[] args) {
		TestDaemon test = new TestDaemon();

		for (int i = 0; i < 2; i++) {

			MyThread thread = test.new MyThread(i);

			if (i == 1) {
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
			if (index == 1) {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(index);
				}
			}else{
				System.out.println(index);
			}

		}

	}

}
