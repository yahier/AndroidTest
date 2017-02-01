package core;

import java.nio.IntBuffer;


/**test IntBuffer   */
public class MyIntBuffer {

	private IntBuffer intBuf = null;

	public MyIntBuffer() {
		intBuf = IntBuffer.allocate(10);
		intBuf.position(3);
	}

	private void startTest() {
		setIntBuf(intBuf);
		printIntBuf(intBuf);
	}

	private void setIntBuf(IntBuffer byteBuf) {
		for (int i = 0; i < byteBuf.capacity() - 3; i++) {
			byteBuf.put(i);
		}
	}

	private void printIntBuf(IntBuffer intBuf) {
		for (int i = 0; i < intBuf.capacity(); i++) {
			System.out.println();
			System.out.print(intBuf.get(i) + " ");
		}
	}

	public static void main(String[] args) {
		MyIntBuffer t1 = new MyIntBuffer();
		t1.startTest();
	}
}
