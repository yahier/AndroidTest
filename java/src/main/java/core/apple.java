package core;

/**
 * 这样的泛型 有什么作用呢
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
		System.out.println("苹果是甜的");
	}

}

class Fruit {
	void taste() {
		System.out.println("什么味道");
	}
}
