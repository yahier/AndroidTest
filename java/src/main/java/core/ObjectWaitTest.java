package core;

class testWait {
	public synchronized void printThreadInfo() {
		Thread t = Thread.currentThread();
		System.out.println("yahier ..");
		// this.wait();//һֱ�ȴ�
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// �ȴ�1000ms
		// super.wait(1000);
	}
}

public class ObjectWaitTest {
	public static void main(String args[]) {
		testWait a = new testWait();
		a.printThreadInfo();
		Thread t = Thread.currentThread();
		System.out.println("ThreadID:" + t.getId() + ", ThreadName:"+ t.getName());
	}
}