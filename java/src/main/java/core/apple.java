package core;

/**
 * �����ķ��� ��ʲô������
 * 
 * @author lenovo
 * 
 * @param <S>
 */
public class apple extends Fruit {
	public static void main(String[] args) {
		Fruit f = new apple();
		f.taste();
	}

	@Override
	void taste() {
		// TODO Auto-generated method stub
		//super.taest();
		System.out.println("ƻ�������");
	}

}

class Fruit {
	void taste() {
		System.out.println("ʲôζ��");
	}
}
