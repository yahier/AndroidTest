package core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// �򵥵ķ���demo  �����޲�����private����
public class Reflect_T {

	public static void main(String[] args) {
		try {
			invoke();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ���ñ����ķ���
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("unchecked")
	static void invoke() throws SecurityException, NoSuchMethodException,
			ClassNotFoundException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {
		Class c = Class.forName("core.InVokeMain");
		Method m = c.getDeclaredMethod("go", null);
		m.setAccessible(true);
		m.invoke(c.newInstance(), null);
	}
}
