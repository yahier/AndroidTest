package core;

/**
 * 测试interface实现监听
 * 
 * @author lenovo
 * 
 */

public class MyInterface {
	onGrowListener mOnGrowListener;
	static int a = 4;

	public static void main(String[] args) {
		MyInterface inter = new MyInterface();

		// 给了监听 然后怎么事件调用呢
		inter.setOnClickListener(new onGrowListener() {

			@Override
			public void go(MyInterface face) {
				// TODO Auto-generated method stub
				System.out.println("调用监听方法");
			}
		});

	}

	public void setOnClickListener(onGrowListener listener) {
		mOnGrowListener = listener;
	}

	public interface onGrowListener {
		void go(MyInterface face);
	}

}
