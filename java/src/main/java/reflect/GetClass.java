package reflect;

import java.lang.reflect.Method;

public class GetClass {
	public static void main(String[] args) {
		
	}
	
	void geClass() throws ClassNotFoundException{
		//Class clazz1 = Stri
				
		String str = "just do it";
		Class cla2 = str.getClass();
		Method[] methods=cla2.getDeclaredMethods();
		for(Method s:methods){
			System.out.println(s.getName());
		}
				
		Class cla3 = Class.forName("java.lang.String");
	}

	
	void getMethods(Class cla) throws SecurityException, NoSuchMethodException{
		Method[] methods1 = cla.getDeclaredMethods();
		Method[] methods2 = cla.getMethods();
		Method method1 = cla.getDeclaredMethod("checkBounds",new Class[]{byte[].class,int.class,int.class});
		Method method2 = cla.getMethod("hashCode");
	}
}
