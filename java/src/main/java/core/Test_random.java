package core;

import java.util.Random;

public class Test_random {
	public static void main(String[] args) {
		Random d = new Random();
		int ranNo = d.nextInt(2);
		System.out.println(ranNo+"    "+ranNo%2);
	}

}

