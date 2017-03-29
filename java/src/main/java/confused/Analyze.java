package confused;

public class Analyze {
	static int[] a = new int[100];
	static int index = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get(20);
		// T(24);
		fenjie(15);

	}

	static void T(int n) {
		for (int i = 0; i < a.length; i++) {// 2 3 5 7 11
			if (n % a[i] == 0)
			{
				n = n / a[i];
				System.out.println(a[i]);
			}

		}
		if (n > 3)
			T(n);

	}

	static void get(int z) {
		for (int i = 1; i <= z; i++) {
			boolean s = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					s = false;
					break;
				}
			}

			if (s == true) {
				In(i);
				System.out.print(i + "  ");
			}
		}
	}

	static void In(int n) {
		a[index++] = n;
	}

	public static void fenjie(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				System.out.println(i + "*"+"         1");
				fenjie(n / i);
			}
		}
		System.out.println(n+"      2");
		//System.exit(0);
	}

}
