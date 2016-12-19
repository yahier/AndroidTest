package wenku;

public class Zhi10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		get(100);
	}

	static void get(int a) {
		int count = 0;
		for (int i = 1; i < a; i++) {
			boolean b = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0)
					b = false;
				break;
			}
			if (b == true) {
				count++;
				System.out.print(i + ",");
				if (count % 9 == 0) {
					System.out.print(i);
					System.out.println();
				}
			}
		}
	}

}
