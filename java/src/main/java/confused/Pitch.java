package confused;


//���ӷ������� ��  ��һ������  �ֱ������������  
//ÿ�ζ��Ƿֵ���Ѷ�һ�� �ӵ�һ���� ��������һ��  ��ʼ�����ж�������
public class Pitch {
	static int ts = 0;// ��������
	 int fs = 1;// ��¼�ֵĴ���
	static int hs = 5;// ������...
	static int tsscope = 5000;// ��������ȡֵ��Χ.̫���������.

	public static void main(String[] args) {
		new Pitch().fT(0);
	}

	public  int fT(int t) {
		if (t == tsscope) {
			// ����������������ȡֵ��Χʱȡ���ݹ�
			System.out.println("����");
			return 0;
		} else {
			if ((t - 1) % hs == 0 && fs <= hs) {
				if (fs == hs) {
					System.out.println("������ = " + ts + " ʱ�����������");
				}
				fs += 1;
				return fT((t - 1) / 5 * 4);// ���غ�������һ�ݺ��ʣ�µ�����
			} else {
				// û��������
				fs = 1;// �ֵĴ�������Ϊ1
				return fT(ts += 1);// ��������+1
			}
		}
	}

}
