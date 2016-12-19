package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class A {
	public static void main(String[] args) {
		sa();
	}

	static void sa() {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date d = new Date();
		String date_s = sdf.format(d);
		System.out.println(date_s);
	}

	static void te2() {
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy",
				Locale.ENGLISH);

		Date d = null;
		try {
			d = sdf.parse("Wed Jan 03 00:00:00 1900");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d));
	}
}
