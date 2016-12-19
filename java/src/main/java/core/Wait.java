package core;

import java.util.concurrent.TimeUnit;
//模拟Wait()与notify()的

class MyObject implements Runnable {
	private Monitor monitor;

	public MyObject(Monitor monitor) {
		this.monitor = monitor;
	}

	public void run() {
		try {
			System.out.println("object wait 3");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("i'm going.");
			monitor.gotMessage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Monitor implements Runnable {
	private volatile boolean go = false;

	public synchronized void gotMessage() throws InterruptedException {
		go = true;
		notify();//通知本线程唤醒来？
	}

	public synchronized void watching() throws InterruptedException {
		while (go == false) {
			System.out.println("111  monitor wating()");
			wait();
		}

		System.out.println("He has gone.");
	}

	public void run() {
		try {
			watching();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Wait {
	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		MyObject o = new MyObject(monitor);
		new Thread(o).start();
		new Thread(monitor).start();
	}
}