package wenku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Change {

	/**
	 * ��ʮλ�� ת���ɶ�λ�� ���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		change16(132);

	}

	static void chan(int a) {// ʮ����ת�����Ƶ�
		boolean[] wo = new boolean[8];
		int in = 0;
		while (a > 0) {
			if (a % 2 == 1)
				wo[in++] = true;// Ϊtrue�ı�ʾ���λ�� ��1
			else
				wo[in++] = false;// ��ʾ��0
			a = a / 2;
		}

		System.out.print("a��Ӧ�Ķ��������ǣ� ");
		for (int i = wo.length - 1; i >= 0; i--) {
			if (wo[i] == true)
				System.out.print(1);
			else
				System.out.print(0);
		}
	}

	static void change16(int a) {// ʮ����ת����16����
		int q = a / 16;// ��ʾǰ���
		int g = a % 16;// �õ���λ������
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

		String he = new Integer(q).toString().concat(ge);//��ôð����ָ���쳣��
		System.out.println(he);

	}

	static void get() {// ������תʮ���Ƶ�
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			System.out.println("������8λ2��������");
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
			System.out.println("ʮ���ƵĽ����" + sum1);
		} catch (IOException e) {
			System.out.println(e.toString());

		}

	}

}
