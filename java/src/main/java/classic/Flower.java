package classic;

public class Flower {

	/**��ô����ˮ�ɻ�����
	 * �ؼ��ǳ�����εõ������λ���ĸ�λ����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		for(int i=100;i<1000;i++){
			int g=i%10;    //�õ���λ�ϵ���
			int s=(i%100-g)/10;   //�õ�����λ���� ��ȥ��λ ����10 �õ�ʮλ
			int b=(i-g-s*10)/100;   //�õ���λ
			
			if(i==b*b*b+s*s*s+g*g*g) 
			System.out.println(i);
			
			
			
			
		}
		
		
	}

}
