package core;

/**
 * ����interfaceʵ�ּ���
 * 
 * @author lenovo
 * 
 */

public class MyInterface {
	onGrowListener mOnGrowListener;
	static int a = 4;

	public static void main(String[] args) {
		MyInterface inter = new MyInterface();

		// ���˼��� Ȼ����ô�¼�������
		inter.setOnClickListener(new onGrowListener() {

			@Override
			public void go(MyInterface face) {
				// TODO Auto-generated method stub
				System.out.println("���ü�������");
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
