package wenku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Change {

	/**
	 * 将十位数 转换成二位数 输出
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		change16(132);

	}

	static void chan(int a) {// 十进制转二进制的
		boolean[] wo = new boolean[8];
		int in = 0;
		while (a > 0) {
			if (a % 2 == 1)
				wo[in++] = true;// 为true的表示这个位上 是1
			else
				wo[in++] = false;// 表示是0
			a = a / 2;
		}

		System.out.print("a对应的二进制数是： ");
		for (int i = wo.length - 1; i >= 0; i--) {
			if (wo[i] == true)
				System.out.print(1);
			else
				System.out.print(0);
		}
	}

	static void change16(int a) {// 十进制转换成16进制
		int q = a / 16;// 表示前面的
		int g = a % 16;// 得到个位的数哈
		String ge = null;
		switch (g) {
		case 10:
			ge = "A";
			break;
		case 11:
			ge = "B";
			break;
		case 12:
			ge = "C";
			break;
		case 13:
			ge = "D";
			break;
		case 14:
			ge = "E";
			break;
		case 15:
			ge = "F";
			break;

		}

		String he = new Integer(q).toString().concat(ge);//怎么冒出空指针异常呢
		System.out.println(he);

	}

	static void get() {// 二进制转十进制的
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			System.out.println("请输入8位2进制数字");
			String line = reader.readLine();
			int sum = 0;
			int sum1 = 0;
			for (int i = 0; i < 8; i++) {
				char c = line.charAt(i);
				if (c == '1' && c < '2') {
					sum = 1;
					for (int j = 0; j < 7 - i; j++) {
						sum *= 2;
					}
					sum1 += sum;
				}
			}
			System.out.println("十进制的结果是" + sum1);
		} catch (IOException e) {
			System.out.println(e.toString());

		}

	}

}
