package confused;

public class YangHui {

	/**
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
				a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
		       
			}

		}


		for (i = 0; i < 8; i++) {
			for (j = 0; j <=i; j++) {
				System.out.printf("  " + a[i][j]);
			}
			System.out.println();
		}
	}

}
