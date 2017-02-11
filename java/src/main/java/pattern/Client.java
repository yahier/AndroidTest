package pattern;

/**
 * 似乎是之前写的适配器模式,但实现的部分写错了。
 */
public class Client implements Adapter1, Adapter2 {
	public static void main(String[] args) {
		Client c = new Client();
		c.combine();
	}

	@Override
	public void goes() {
		// TODO Auto-generated method stub
		System.out.println("goes");
	}

	@Override
	public void come() {
		// TODO Auto-generated method stub
		System.out.println("comes");
	}

	public void combine() {

		come();
		goes();
	}
}
