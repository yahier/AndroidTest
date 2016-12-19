package annotation;

import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException {

		Class<Other> c = Other.class;
		Method method = c.getMethod("doOther");

		Bingo bingo = method.getAnnotation(Bingo.class);
		System.out.println("注释值是:"+bingo.num());
	}
}