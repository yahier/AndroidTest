package reflect;

import java.lang.reflect.Method;

public class GetClass {
	public static void main(String[] args) {
		
	}
	
	void geClass() throws ClassNotFoundException{
		//第一种获取方法，直接了当
		//Class clazz1 = String.class;
				
		//第二种获取方法，对实体类运用方法
		String str = "just do it";
		Class cla2 = str.getClass();
		Method[] methods=cla2.getDeclaredMethods();
		for(Method s:methods){
			System.out.println(s.getName());
		}
				
		//第三种获取方法，直接传递一个类名，字符串形式
		Class cla3 = Class.forName("java.lang.String");
	}

	
	void getMethods(Class cla) throws SecurityException, NoSuchMethodException{
		Method[] methods1 = cla.getDeclaredMethods();
		Method[] methods2 = cla.getMethods();
		Method method1 = cla.getDeclaredMethod("checkBounds",new Class[]{byte[].class,int.class,int.class});
		Method method2 = cla.getMethod("hashCode");
	}
}
