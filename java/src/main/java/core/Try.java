package core;

/**
 *如果有finally和return和finally，会在执行finally之后，再执行return,理解上可以觉得try方法中，先记录下返回值，再执行finally。
 */
public class Try {
	public static void main(String[] args) {
		System.out.println(getSomething());
	}

	static int getSomething() {
		int i = 0;
		try {
			i = 10 / i;
			return i;
		} catch (Exception e) {
			return i;
		} finally {
			i++;
			return i;
		}

	}
}
