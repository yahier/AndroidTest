package test;

import java.util.regex.Pattern;

public class Patt {

	public static void main(String[] args) {
		Patt p = new Patt();
		System.out.println(p.t());
	}

	boolean t() {
		boolean b = Pattern.matches("\\d#\\d#\\d#", "5#2#6#");
		return b;
	}
}
