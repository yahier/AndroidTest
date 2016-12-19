package pass;

/**���Ծ�̬������빹�캯���ִ��˳��
 * ������д�ķ��� �Ƿ���Ը�ķ������� 
 * @author lenovo
 *
 */
public class T extends F{
	public static void main(String[] args) {
		F f = new T();//��������������������ʱ  ������ʲô
		
		
	}
	
	@Override
	void get() {
		// TODO Auto-generated method stub
		super.get();
	}
	
	
	static {
		System.out.println("T �ľ�̬����");
	}
	
	
   
	public T(){
		System.out.println("����T��Ĺ��캯��");
	}
	
}


class F{
	static{
		System.out.println("F��̬�����");
	}
	
	public F() {
		// TODO Auto-generated constructor stub
		System.out.println("F�Ĺ��캯��");
	}
	
	void get(){
		
	}
}