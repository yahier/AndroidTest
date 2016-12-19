package wenku;

public class Dicheng {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		get(5);
	}

	static void get(int i) {
		int sum = 0, s = 1;
		for (int n = 1; n <= i; n++) {
			s = s * n;
			sum = sum + s;
		}

		System.out.println(sum);
	}
}
