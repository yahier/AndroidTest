package grammer;

import grammer.MyActivity.Sky;

public class Two implements Sky {
	public static void main(String[] args) {
		t();
	}



	/**break  这样设置断点 是没有价值的 */
	static void t() {
		scan: {
			for (int i = 0; i < 3; i++) {

				if (i == 1) {
					break scan;
				}
				System.out.println(i);
			}
		}

		System.out.println("");
	}
	
	
	



	@Override
	public int get() {
		// TODO Auto-generated method stub
		//测试在方法中   访问内部接口的Activity变量
		return 0;
		
	}
}
