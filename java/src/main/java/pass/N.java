package pass;

public class N {
	public static void main(String[] args) {
		N n= new N();
		n.two();
	}

	void one(){
		int a =2;
		int b = a<<(3);
		System.out.println(b);
		
	}
	
	void two(){
		String a = "hello";
		String b = new String("hello");
		String c = null;//ǿ�Ƴ�ʼ������Ȼ���벻��
		char[] chars = {'h','e','l','l','o'};
		if(a.equals(chars)){
			System.out.println("Ӧ�ò�һ��");
		}
		
		System.out.println("c is "+c);//��ӡ�� c is null
	
	    if(a==b){
	    	System.out.println("��Ȼ�ǲ����");
	    }
	
	}
	
	void three(){
		
	}
}
