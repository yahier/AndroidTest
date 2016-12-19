package math;

public class Mult {
static int sum=1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 5, sum = 1;
		while (a > 0) {
			sum *= a--;
		}
		System.out.println(sum);
		System.out.println(digui(5));

	}

	// �ݹ鰡 ��������˰�

		static int digui(int n){
			if(n == 1){
			return 1;
			}
			return n * digui(n - 1);
			}

}
