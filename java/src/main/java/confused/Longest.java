package confused;

public class Longest {

	/**
	 * �ƽ̨ �����е�ƽ̨��λ�ö��ҳ��� �����õݹ��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4, 4, 4,4, 5, 5,5 };
		get(a);
	}

	static void get(int[] a) {
		int l = 1, longth = 0;
		for (int i = 0; i < a.length-1; i++) {
			if (a[i] == a[i + 1])
				l++;
			else
				l = 1;
			
			if (l > longth)
				longth = l;
		}
		
		System.out.print(longth);
	}

	static void gui(int[] a){
		
	}
}
