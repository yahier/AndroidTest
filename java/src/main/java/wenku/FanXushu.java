package wenku;

public class FanXushu {

	/**
	 * @param args
	 * 判断反序数
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1000; i < 10000; i++) {
			int an = i * 9;
			StringBuffer buffer1 =new StringBuffer( (new Integer(i).toString()));
			StringBuffer buffer2 = new StringBuffer((new Integer(an).toString()));
			if (buffer1.reverse().equals(buffer2))//奇怪啊 1089 与 9801应该满足条件的
				System.out.println("ddf");

		}
	}

}
