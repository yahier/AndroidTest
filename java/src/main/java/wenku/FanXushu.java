package wenku;

public class FanXushu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1000; i < 10000; i++) {
			int an = i * 9;
			StringBuffer buffer1 =new StringBuffer( (new Integer(i).toString()));
			StringBuffer buffer2 = new StringBuffer((new Integer(an).toString()));
			if (buffer1.reverse().equals(buffer2))
				System.out.println("ddf");

		}
	}

}
