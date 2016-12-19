package math;

import java.text.DecimalFormat;
import java.util.Locale;

public class NumberFormatTest {
	public static void main(String[] args) {
		test();
	}

	static void test() {
		DecimalFormat format = new DecimalFormat("##,##.000");
		System.out.println("a:" + format.format(1112356.12272));//
		DecimalFormat percentFormat = new DecimalFormat("#0.000%");
		System.out.println("f:" + percentFormat.format(0.3052222));// 
	}

}
