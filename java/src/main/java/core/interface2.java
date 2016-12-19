package core;

public class interface2 {
	public static void main(String[] args) {
		ya y = new ya();
		y.ha();
	}

}

class ya implements go {
	void ha() {
		String con = one();
		three(con);

	}

	@Override
	public String one() {
		// TODO Auto-generated method stub
		return "256789";
	}

	@Override
	public void three(String c) {
		// TODO Auto-generated method stub
		System.out.println(c);
	}

	@Override
	public void two() {
		// TODO Auto-generated method stub
		System.out.println(333);
	}

}

interface go {
	String one();

	void two();

	void three(String c);
}