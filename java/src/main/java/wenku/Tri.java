package wenku;

public class Tri {

	/**��������˹�  �ؼ���for����еı䶯
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3, k;
		int i = 5;// ������һ��ķ�����
		int p = 2;// ��һ��ǰ��Ŀո���

		for (int h = 1; h < 6; h++) {// ���Ǳ�ʾ��
			for (k=a; k >= 0; k--) {// ǰ��Ŀո���

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
