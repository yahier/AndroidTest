package thread;

public class TestPriority {
	
	public static void main(String[] args) {
		for(int i=1;i<11;i++){
			final int j = i;
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("run "+j);
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
