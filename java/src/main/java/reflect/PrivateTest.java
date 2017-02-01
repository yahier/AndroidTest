package reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class PrivateTest {

	public static void main(String[] args) throws Exception {
		Class<?> clazz = Private.class;
		Constructor<?> constructor = clazz.getConstructor(new Class<?>[] {String.class, int.class });
		Method method = clazz.getDeclaredMethod("doPrivate", new Class<?>[] {});
		method.setAccessible(true);
		Object obj = constructor.newInstance("star", 23);
		String results = (String) method.invoke(obj);
		System.out.println(results);
	}
}

class Private {
	private String name;
	private int age;

	public Private(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private String doPrivate() {
		return "name:" + name + "   age:" + age;
	}
}
