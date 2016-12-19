package reflect;

import java.lang.reflect.Field;

public class T_Integer {
	public static void main(String[] args) {
		int a =2;
		T_Integer t = new T_Integer();
		t.test(a);
	}
	
	void test(int a){
		//Class c = a.
		Class it = new Integer(a).getClass();
		Field[] f = it.getFields();
		for(int i=0;i<f.length;i++){
			System.out.println(f[i].getName());
		}
		
		try {
			try {
				System.out.println(it.getField("SIZE").get(it));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
