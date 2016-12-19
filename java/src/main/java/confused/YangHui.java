package confused;

public class YangHui {

	/**
	 * @param args
	 * 
	 * 输出有误  第二行应该是 1 1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j;
		int a[][];
		a = new int[8][8];

		for (i = 0; i < 8; i++) {
			a[i][i] = 1;
			a[i][0] = 1;
		 

		}
		for (i = 2; i < 8; i++) {
			for (j = 1; j <= i - 1; j++) {
				a[i][j] = a[i - 1][j - 1] + a[i - 1][j]; // 等于上左 和 左侧
		       
			}

		}

		// 输出错误的原因是 这里并没有指出最右边上面的一层都是1

		for (i = 0; i < 8; i++) { // 关键是 怎么按规则的输出
			for (j = 0; j <=i; j++) {//换成for (j = 0; j <i; j++)  会有奇怪后果  求解释 
				System.out.printf("  " + a[i][j]);
			}
			System.out.println();
		}
	}

}
