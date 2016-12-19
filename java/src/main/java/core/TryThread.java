package core;

//测试Object的wait()方法。。出错
public class TryThread {
	static int a = 0;

	public static void main(String[] args) {
		TryThread main = new TryThread();
		Run run = new Run();
		Run2 run2 = new Run2(run);
		new Thread(run).start();
		new Thread(run2).start();
		

	}

}

//wait与notify   必须由 拥有这个对象monitor的线程调用    
class Run implements Runnable {

	@Override
	public void run() {
		method();
	}

	synchronized void method() {

		try {
			System.out.println("wait  1");
			wait();
			System.out.println("wait  2");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	 
	synchronized void noti() {
		notifyAll();
	}
};

class Run2 implements Runnable {
	Run run;

	public Run2(Run run) {
		this.run = run;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		run.noti();
	}

}