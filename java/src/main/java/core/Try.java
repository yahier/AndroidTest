package core;

public class Try {
	public static void main(String[] args) {
		System.out.println(getSomething());
	}

	static int getSomething() {
		int i = 0;
		try {
			i = 10 / i;
			return i;
		} catch (Exception e) {
			return i;
		} finally {
			i++;
			return i;
		}

	}
}
