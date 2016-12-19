package wenku;

public class Tri {

	/**终于完成了哈  关键是for语句中的变动
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3, k;
		int i = 5;// 最下面一层的符号数
		int p = 2;// 第一排前面的空格数

		for (int h = 1; h < 6; h++) {// 这是表示层
			for (k=a; k >= 0; k--) {// 前面的空格数

				System.out.print(" ");
			}
			a--;
			for (int g = 1; g < p; g++) {
				System.out.print("*");
			}
			System.out.println();
			p=p+2;

		}
		
		
	}
}
