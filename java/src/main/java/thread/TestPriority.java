package thread;

/**
 * 测试线程优先级，只有大概的总结。不能严格依靠线程来制定优先级
 */
public class TestPriority {
	
	public static void main(String[] args) {
		for(int i=1;i<11;i++){
			final int j = i;
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("run1 "+j);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("run2 "+j);
				}
			});
			
			thread.setPriority(i);
			thread.start();
		
			
		}
	}

}
